class Solution:
    def minimumCost(self, source, target, original, changed, cost):
        num_characters = 26
        distances = [[float('inf')] * num_characters for _ in range(num_characters)]

        for i in range(num_characters):
            distances[i][i] = 0

        for i in range(len(original)):
            src_char = ord(original[i]) - ord('a')
            dst_char = ord(changed[i]) - ord('a')
            weight = cost[i]

            distances[src_char][dst_char] = min(distances[src_char][dst_char], weight)

        for k in range(num_characters):
            for i in range(num_characters):
                for j in range(num_characters):
                    distances[i][j] = min(distances[i][j], distances[i][k] + distances[k][j])

        total_cost = 0
        for i in range(len(source)):
            src_char = ord(source[i]) - ord('a')
            dest_char = ord(target[i]) - ord('a')
            if src_char == dest_char:
                continue
            if distances[src_char][dest_char] == float('inf'):
                return -1
            else:
                total_cost += distances[src_char][dest_char]
        return total_cost
