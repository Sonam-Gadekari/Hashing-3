import java.util.*;

class Solution {
    // Tc: O(m*n)
    // Sc: O(n)
    public Map<String, List<String>> favoritegenre(Map<String, List<String>> userSongs,
            Map<String, List<String>> songGenres) {
        Map<String, List<String>> res = new HashMap<>();
        Map<String, String> songstogenre = new HashMap<>();

        for (String genre : songGenres.keySet()) {
            List<String> songs = songGenres.get(genre);
            for (String song : songs) {
                songstogenre.put(song, genre);
            }
        }
        Map<String, Integer> cnt;
        int max;
        for (String user : userSongs.keySet()) {
            cnt = new HashMap<>();
            max = 0;
            res.put(user, new ArrayList<>());
            List<String> songs = userSongs.get(user);
            for (String song : songs) {
                String genre = songstogenre.getOrDefault(song, "Unknown");
                int c = cnt.getOrDefault(genre, 0) + 1;
                cnt.put(genre, c);
                max = Math.max(c, max);
            }
            for (String key : cnt.keySet()) {
                if (cnt.get(key) == max) {
                    res.get(user).add(key);
                }
            }
        }
        return res;
    }
}

public class favGenre {
    public static void main(String[] args) {
        Map<String, List<String>> userSongs = new HashMap<>();
        userSongs.put("David", Arrays.asList("song1", "song2", "song3", "song4", "song8"));
        userSongs.put("Emma", Arrays.asList("song5", "song6", "song7"));

        Map<String, List<String>> songGenres = new HashMap<>();
        songGenres.put("Rock", Arrays.asList("song1", "song3"));
        songGenres.put("Dubstep", Arrays.asList("song7"));
        songGenres.put("Techno", Arrays.asList("song2", "song4"));
        songGenres.put("Pop", Arrays.asList("song5", "song6"));
        songGenres.put("Jazz", Arrays.asList("song8", "song9"));

        Solution solution = new Solution();
        Map<String, List<String>> userFavoriteGenres = solution.favoritegenre(userSongs, songGenres);

        for (Map.Entry<String, List<String>> entry : userFavoriteGenres.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
