interface Button{
    public void info();
}
class BasicButton implements Button{
    public void info(){
        System.out.println("Это кнопка");
    }
}
abstract class ButtonDecorator implements Button{
    Button buttonDecorator;
    public ButtonDecorator(Button buttonDecorator) {
        this.buttonDecorator = buttonDecorator;
    }
    public void info(){ buttonDecorator.info();}
}
class ImageButton extends ButtonDecorator{
    public ImageButton(Button buttonDecorator){
        super(buttonDecorator);
    }
    public void info(){
        buttonDecorator.info();
        imageInfo();
    }
    public void imageInfo(){
        System.out.println("Это кнопка с рисунком");
    }
}

class TextButton extends ButtonDecorator{
    public TextButton(Button buttonDecorator){
        super(buttonDecorator);
    }
    public void info(){
        buttonDecorator.info();
        textInfo();
    }
    public void textInfo(){
        System.out.println("Это кнопка с надписью");
    }
}

class CircleImageButton extends ButtonDecorator{
    public CircleImageButton(Button buttonDecorator) {
        super(buttonDecorator);
    }

    public void info(){
        buttonDecorator.info();
        circleInfo();
    }
    public void circleInfo(){
        System.out.println("Это кнопка круглая");
    }

}
public class Main {
    public static void main(String[] args) {
        Button basicButton = new BasicButton();
        basicButton.info();
        System.out.println();

        Button imageButton = new ImageButton(basicButton);
        imageButton.info();
        System.out.println();

        Button textButton = new TextButton(basicButton);
        textButton.info();
        System.out.println();

        Button circleImageButton = new CircleImageButton(imageButton);
        circleImageButton.info();
    }
}