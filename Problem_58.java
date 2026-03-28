class Solution {
    public int lengthOfLastWord(String s) {
        // Trim trailing spaces
        s = s.trim();
        
        // Find the last space in the trimmed string
        int lastSpaceIndex = s.lastIndexOf(' ');
        
        // The last word is the substring after the last space
        return s.length() - lastSpaceIndex - 1;
    }
}
