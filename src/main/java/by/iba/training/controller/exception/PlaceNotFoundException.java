package by.iba.training.controller.exception;

public class PlaceNotFoundException extends RuntimeException {
    public PlaceNotFoundException(Integer id) {
        super("Could not find the place" + id);
    }
}
