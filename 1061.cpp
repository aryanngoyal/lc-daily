// graph, bfs, dfs, string

class Solution {

private:
    int getLexographicalWeight(char ch) {
        return ch - 'a';
    }

    char lexographicalWeightToChar(int weight) {
        return 'a' + weight;
    }

    int getSmallestEquivalent(const vector<vector<int>>& adj, int src, vector<bool>& vis) {
        int smallestEquivalent = src;
        vis[src] = true;
        for (int nextVertex : adj[src]) {
            if (!vis[nextVertex]) {
                smallestEquivalent = min(smallestEquivalent, getSmallestEquivalent(adj, nextVertex, vis));
            }
        }
        return smallestEquivalent;
    }

    int getSmallestEquivalent(const vector<vector<int>>& adj, int src) {
        vector<int> smallestEquivalent(26, false);
        return getSmallestEquivalent(adj, src, vis);
    }

public:
    string smallestEquivalentString(string s1, string s2, string baseStr) {
        vector<vector<int>> adj(26, vector<int>());
        int s1Length = s1.size();

        for (int idx = 0; idx < s1Length; idx++) {
            char c1 = s1[idx], c2 = s2[idx];
            int w1 = getLexographicalWeight(c1), w2 = getLexographicalWeight(c2);
            adj[w1].push_back(w2);
            adj[w2].push_back(w1);
        }

        vector<int> smallestWeightEquivalent(26);
        for (int w = 0; w < 26; w++) {
            smallestWeightEquivalent[w] = getSmallestEquivalent(adj, w);
        }

        string smallestEquivalentOfBaseStr;
        for (char ch : baseStr) {
            int lexoWeight = getLexographicalWeight(ch);
            int equivalentLowestLexoWeight = smallestWeightEquivalent[lexoWeight];
            smallestEquivalentOfBaseStr += lexographicalWeightToChar(equivalentLowestLexoWeight);
        }

        return smallestEquivalentOfBaseStr;
    }
};

