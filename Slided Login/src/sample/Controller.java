package sample;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.util.Duration;


public class Controller {

	@FXML
	private Pane pane1;

	@FXML
	private Pane pane2;

	@FXML
	private Pane pane3;

	@FXML
	private Pane pane4;
	
	FadeTransition ftPane4;
	FadeTransition ftPane3;
	FadeTransition ftPane2;

	public void initialize() {

		pane1.setStyle("-fx-background-image: url('sample/1.jpg')");
		pane2.setStyle("-fx-background-image: url('sample/2.jpg')");
		pane3.setStyle("-fx-background-image: url('sample/3.jpg')");
		pane4.setStyle("-fx-background-image: url('sample/4.jpg')");

		backgroundAnimation();

	}

	private void backgroundAnimation() {
		
		ftPane4 = new FadeTransition(Duration.seconds(5), pane4);
		ftPane3 = new FadeTransition(Duration.seconds(3), pane3);
		ftPane2 = new FadeTransition(Duration.seconds(3), pane2);

		ftPane4.setFromValue(1);
		ftPane4.setToValue(0);
		ftPane4.play();

		ftPane4.setOnFinished(event -> {
	
			ftPane3.setFromValue(1);
			ftPane3.setToValue(0);
			ftPane3.play();
					
			ftPane3.setOnFinished(event1 -> {
				ftPane2.setFromValue(1);
				ftPane2.setToValue(0);
				ftPane2.play();

				ftPane2.setOnFinished(event2 -> {

					ftPane2.setFromValue(0);
					ftPane2.setToValue(1);
					ftPane2.play();

					ftPane2.setOnFinished(event3 -> {

						ftPane3.setFromValue(0);
						ftPane3.setToValue(1);
						ftPane3.play();

						ftPane3.setOnFinished(event4 -> {

							ftPane4.setFromValue(0);
							ftPane4.setToValue(1);
							ftPane4.play();

							ftPane4.setOnFinished(event5 -> {

								backgroundAnimation();
							});
						});

					});

				});
				
			});
		});
	}
}
