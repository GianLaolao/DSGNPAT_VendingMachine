package backend;

public class VendoFactory {

    public RegularVendo getNewRegularVendo()
    {
        return new RegularVendo();
    }

    public SpecialVendo getNewSpecialVendo()
    {
        return new SpecialVendo();
    }
}
