//Design a text editor with a cursor that can do the following:
//
// 
// Add text to where the cursor is. 
// Delete text from where the cursor is (simulating the backspace key). 
// Move the cursor either left or right. 
// 
//
// When deleting text, only characters to the left of the cursor will be 
//deleted. The cursor will also remain within the actual text and cannot be moved beyond 
//it. More formally, we have that 0 <= cursor.position <= currentText.length 
//always holds. 
//
// Implement the TextEditor class: 
//
// 
// TextEditor() Initializes the object with empty text. 
// void addText(string text) Appends text to where the cursor is. The cursor 
//ends to the right of text. 
// int deleteText(int k) Deletes k characters to the left of the cursor. 
//Returns the number of characters actually deleted. 
// string cursorLeft(int k) Moves the cursor to the left k times. Returns the 
//last min(10, len) characters to the left of the cursor, where len is the number 
//of characters to the left of the cursor. 
// string cursorRight(int k) Moves the cursor to the right k times. Returns the 
//last min(10, len) characters to the left of the cursor, where len is the number 
//of characters to the left of the cursor. 
// 
//
// 
// Example 1: 
//
// 
//Input
//["TextEditor", "addText", "deleteText", "addText", "cursorRight", 
//"cursorLeft", "deleteText", "cursorLeft", "cursorRight"]
//[[], ["leetcode"], [4], ["practice"], [3], [8], [10], [2], [6]]
//Output
//[null, null, 4, null, "etpractice", "leet", 4, "", "practi"]
//
//Explanation
//TextEditor textEditor = new TextEditor(); // The current text is "|". (The '|
//' character represents the cursor)
//textEditor.addText("leetcode"); // The current text is "leetcode|".
//textEditor.deleteText(4); // return 4
//                          // The current text is "leet|". 
//                          // 4 characters were deleted.
//textEditor.addText("practice"); // The current text is "leetpractice|". 
//textEditor.cursorRight(3); // return "etpractice"
//                           // The current text is "leetpractice|". 
//                           // The cursor cannot be moved beyond the actual 
//text and thus did not move.
//                           // "etpractice" is the last 10 characters to the 
//left of the cursor.
//textEditor.cursorLeft(8); // return "leet"
//                          // The current text is "leet|practice".
//                          // "leet" is the last min(10, 4) = 4 characters to 
//the left of the cursor.
//textEditor.deleteText(10); // return 4
//                           // The current text is "|practice".
//                           // Only 4 characters were deleted.
//textEditor.cursorLeft(2); // return ""
//                          // The current text is "|practice".
//                          // The cursor cannot be moved beyond the actual 
//text and thus did not move. 
//                          // "" is the last min(10, 0) = 0 characters to the 
//left of the cursor.
//textEditor.cursorRight(6); // return "practi"
//                           // The current text is "practi|ce".
//                           // "practi" is the last min(10, 6) = 6 characters 
//to the left of the cursor.
// 
//
// 
// Constraints: 
//
// 
// 1 <= text.length, k <= 40 
// text consists of lowercase English letters. 
// At most 2 * 10⁴ calls in total will be made to addText, deleteText, 
//cursorLeft and cursorRight. 
// 
// 👍 7 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q2296DesignATextEditor {
    public static void main(String[] args) {

        //Solution solution = new Q2296DesignATextEditor().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class TextEditor {

        StringBuilder sb;
        int cursor; // 光标索引(表示此时光标前有多少个字符)

        public TextEditor() {
            sb = new StringBuilder();
            cursor = 0;
        }

        // 将 text 添加到光标所在位置。添加完后光标在 text 的右边
        public void addText(String text) {
            sb.insert(cursor, text);    // 注意这里用insert API
            cursor += text.length();
        }

        // 删除光标左边 k 个字符。返回实际删除的字符数目。
        public int deleteText(int k) {
            if (cursor <= k) {
                // 1.光标左边不够删除
                int oldCursor = cursor;
                sb.replace(0, oldCursor, "");   // 注意用replace API
                cursor = 0;
                return oldCursor;
            } else {
                // 2.光标左边够删除
                sb.replace(cursor - k, cursor, "");
                cursor -= k;
                return k;
            }
        }

        // 将光标向左移动 k 次。返回移动后光标左边 min(10, len) 个字符，其中 len 是光标左边的字符数
        public String cursorLeft(int k) {
            if (cursor >= k) {
                // 1.左边够移动
                cursor -= k;
                // 返回光标左边 min(10, len)
                return cursor >= 10 ? sb.substring(cursor - 10, cursor) : sb.substring(0, cursor);
            } else {
                // 2.左边不够移动
                cursor = 0;
                return "";
            }
        }

        // 将光标向右移动 k 次。返回移动后光标左边 min(10, len) 个字符，其中 len 是光标左边的字符数目。
        public String cursorRight(int k) {
            int len = sb.length();
            if (cursor + k <= len) {
                // 1.右边够移动
                cursor += k;
                // 返回光标左边 min(10, len)
                return cursor >= 10 ? sb.substring(cursor - 10, cursor) : sb.substring(0, cursor);
            } else {
                // 2.右边不够移动
                cursor = len;
                return cursor >= 10 ? sb.substring(cursor - 10, cursor) : sb.substring(0, cursor);
            }
        }
    }

/**
 * Your TextEditor object will be instantiated and called as such:
 * TextEditor obj = new TextEditor();
 * obj.addText(text);
 * int param_2 = obj.deleteText(k);
 * String param_3 = obj.cursorLeft(k);
 * String param_4 = obj.cursorRight(k);
 */
//leetcode submit region end(Prohibit modification and deletion)

}