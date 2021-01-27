module com.tele.evluation.uma {
	requires transitive javafx.controls;
	requires javafx.fxml;
	requires jdk.compiler;
	requires transitive javafx.web;
	
	opens com.tele.evluation.uma to javafx.fxml;
	opens com.tele.evluation.uma.controlers to javafx.fxml;
	opens com.tele.evluation.uma.model.view to javafx.fxml;
	
	exports com.tele.evluation.uma;
	exports com.tele.evluation.uma.controlers;
	exports com.tele.evluation.uma.model.viewbn ;
}
