package agh.ics.oop.gui;
import agh.ics.oop.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.util.List;

public class App extends Application {
    private IWorldMap map;
    private final GridPane gridPane= new GridPane();
    public static int moveDelay = 300;
    private SimulationEngine engine;

    public void init(){
        List<String> rawParameters = getParameters().getRaw();
        String[] argsArray = new String[rawParameters.size()];
        rawParameters.toArray(argsArray);
        this.map = new GrassField(15);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        this.engine = new SimulationEngine(map, positions);
        this.engine.setObserver(this);
    }

    // Przychodzi powiadomienie od Engina, że coś się na mapie zmieniło przekuzując nową mapę,
    // więc musimy dokonać aktualizacji.
    public void update(IWorldMap updatedMap) throws InterruptedException {
        Platform.runLater(()-> {
            //Usuwam linię z mapy
            this.gridPane.setGridLinesVisible(false);
            //Czyszczenie mapy
            this.gridPane.getChildren().clear();
            this.gridPane.getColumnConstraints().clear();
            this.gridPane.getRowConstraints().clear();
            // Tworzę nową mapę.
            createGridPane(updatedMap);
        });
        try{
            Thread.sleep(moveDelay);

        }catch (InterruptedException exception){
            throw new InterruptedException(exception.getMessage());
        }
    }

    private void createGridPane(IWorldMap map){
        AbstractWorldMap newMap = (AbstractWorldMap) map ;
        this.gridPane.setGridLinesVisible(true);
        Vector2d lowerLeft = newMap.getLowerLeftBorder();
        Vector2d upperRight = newMap.getUpperRightBorder();

        int width = upperRight.x - lowerLeft.x +2;
        int height= upperRight.y - lowerLeft.y +2;

        ColumnConstraints colConst = new ColumnConstraints(40);
        RowConstraints rowConst = new RowConstraints(40);

        //Każdej kolumnie ustawiam tę samą szerokość.
        for(int i = 0; i < width; i++){
            this.gridPane.getColumnConstraints().add(colConst);
        }
        //Każdemu wierszowi ustawiam tę samą szerokość.
        for(int i = 0; i < height; i++){
            this.gridPane.getRowConstraints().add(rowConst);
        }

        Label zeroZero = new Label("y/x");
        this.gridPane.add(zeroZero,0,0,1,1);
        GridPane.setHalignment(zeroZero, HPos.CENTER);

        for(int i=0; i<height-1;i++){
            Label label = new Label(String.valueOf(upperRight.y - i));
            this.gridPane.add(label,0,i+1);
            GridPane.setHalignment(label, HPos.CENTER);
        }

        for(int i=0; i<width-1;i++){
            Label label = new Label(String.valueOf(lowerLeft.x + i));
            this.gridPane.add(label,i+1,0);
            GridPane.setHalignment(label, HPos.CENTER);
        }

        for(Grass grass : newMap.getGrasses().values()){
            this.gridPane.add(new GuiElementBox(grass).getBox(),grass.getPosition().x -lowerLeft.x + 1,upperRight.y -grass.getPosition().y + 1);
        }

        for(Animal animal : newMap.getAnimals().values()){
            this.gridPane.add(new GuiElementBox(animal).getBox(),animal.getPosition().x -lowerLeft.x + 1,upperRight.y -animal.getPosition().y + 1);
        }
    }

    private HBox createInputArea(){
        HBox hBox = new HBox(10);
        Label label = new Label("Enter moves");
        label.setFont(new Font("Arial",20));
        TextField inputValue = new TextField();
        Button startButton = new Button("Start");
        startButton.setOnAction(event -> {
            MoveDirection[] moveDirections = new OptionsParser().parse(inputValue.getText().split(" "));
            this.engine.setDirections(moveDirections);
            Thread thread = new Thread(this.engine);
            thread.setDaemon(true);
            thread.start();
        });
        hBox.getChildren().addAll(label,inputValue,startButton);
        return hBox;
    }

    @Override
    public void start(Stage primaryStage){
        VBox mainScene = new VBox(10);
        mainScene.setPadding(new Insets(10,10,10,10));
        HBox inputArea = createInputArea();
        createGridPane(this.map);
        mainScene.getChildren().addAll(this.gridPane,inputArea);
        Scene scene = new Scene(mainScene,600,630);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
