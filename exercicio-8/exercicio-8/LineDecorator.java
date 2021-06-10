public class LineDecorator
{
    protected String lLine;
    protected int num;
    LineDecorator(String lLine, int num) {
        this.lLine = lLine;
        this.num = num;
    }
    String getDecoratedLine() 
    {
        return String.valueOf(this.num) + ':' + this.lLine;
    }
}
