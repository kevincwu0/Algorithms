
// #535 Encode and Decode TinyURL

// Using Simple Counter
// URL along with its encoded count(i) in a hashmap
// Performance analysis
// Limited by the range of int
// Integer overflow could lead to overwriting previous URL encodings -> performance degradation
// Length of the URL isn't necessarily shorter than the incoming longURL

public class Solution {
    Map<Integer, String> map = new HashMap<>();
    int i = 0;
    
    // Encodes a URL to a shortened URL
    public String encode(String longUrl) {
        map.put(i, longUrl);
        return "http://tinyurl.com/" + i++;
    }
    // Decodes a shortened URL to its original URL
    public String decode(String shortUrl) {
        return map.get(Integer.parseInt(shortUrl.replace("http://tinyurl.com", "")));
    }
}

// HashCode
// inbuilt hashCode() -> code for mapping every URL
// # of URLs that can be encoded is limited by the range of int, since hashCode uses integer calc
// Hash Collisions -> number of encoded URLs increases, probability of collisions increases
public class Solution {
    Map<Integer, String> map = new HashMap<>();
    
    public String encode(String longUrl) {
        map.put(longUrl.hashCode(), longUrl);
        return "http://tinyurl.com/" + longUrl.hashCode();
    }
    
    public String decode(String shortUrl) {
        return map.get(Integer.parseInt(shortUrl.replace("http://tinyurl.com/", "")));
    }
}


// Approach #5 Random fixed-length encoding
public class Solution {
    String alphabet = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    HashMap<String, String> map = new HashMap<>();
    Random rand = new Random();
    String key = getRand();

    public String getRand() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            sb.append(alphabet.charAt(rand.nextInt(62)));
        }
        return sb.toString();
    }

    public String encode(String longUrl) {
        while (map.containsKey(key)) {
            key = getRand();
        }
        map.put(key, longUrl);
        return "http://tinyurl.com/" + key;
    }

    public String decode(String shortUrl) {
        return map.get(shortUrl.replace("http://tinyurl.com/", ""));
    }
}