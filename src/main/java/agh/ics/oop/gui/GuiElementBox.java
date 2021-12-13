package agh.ics.oop.gui;

import agh.ics.oop.Animal;
import agh.ics.oop.IMapElement;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class GuiElementBox {
    IMapElement element;

    public GuiElementBox(IMapElement element){
        this.element=element;
    }

    public VBox getBox(){
        VBox box = new VBox();
        Label label;
        if(element instanceof Animal){
            label = new Label("Z" + " (" + element.getPosition().x + "," + element.getPosition().y + ")");
        }
        else {
            label = new Label("Trawa");
        }
        box.getChildren().add(getImage(this.element));
        box.getChildren().add((label));
        box.setAlignment(Pos.CENTER);
        return box;
    }

    private ImageView getImage(IMapElement element){
        String sourcePath = element.getResourceName();
        Image image = null;
        try {
            image = new Image(new FileInputStream(sourcePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(20);
        imageView.setFitHeight(20);
        return imageView;
    }

}
