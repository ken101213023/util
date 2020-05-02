package test;
public class CSVUtil{
  public static List splitCsvLine(String line) {
    Pattern singleQuotePattern = Pattern.compile("^'([^'].*?)'([,]?.*)$");
    Pattern doubleQuotePattern = Pattern.compile("^\"([^\"].*?)\"([,]?.*)$");
    Pattern numberPattern = Pattern.compile("^([0-9]+)([,]?.*)$");
 
    List columns = new ArrayList();
    while(StringUtilz.isNotBlank(line)){
 
      // 處理 "" 空的字串
      if(line.startsWith("\"\",") || line.startsWith("'',")){
        line = line.substring(3);
        columns.add("");
      }
 
      // 結尾部分
      if("\"\"".equals(line)||"''".equals(line)){
        line = "";
        columns.add("");
      }
 
      line = parse(line, columns, singleQuotePattern.matcher(line));
      line = parse(line, columns, doubleQuotePattern.matcher(line));
      line = parse(line, columns, numberPattern.matcher(line));
    }
    return columns;
  }
 
  static String parse(String line, List list, Matcher m) {
    if(m.matches()){
      // 文字
      list.add(m.group(1));
      line = m.group(2);
      // 去,點開頭
 
      // 數字的欄位為空時不會有引號, 需特別處理
      while(line.startsWith(",,")){
        list.add("");
        line = line.substring(2);
      }
 
      while(line.startsWith(",")){
        line = line.substring(1);
      }
    }
    return line;
  }
}