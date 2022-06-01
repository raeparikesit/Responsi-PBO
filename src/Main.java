
import controller.ControllerData;
import view.ViewData;
import model.ModelData;
import controller.ControllerData;

public class Main {
    

    public static void main(String[] args) {
        view.ViewData view = new view.ViewData();
        model.ModelData model = new model.ModelData();
        controller.ControllerData controller = new controller.ControllerData(model, view);
        view.setVisible(true);
    }
    
}
