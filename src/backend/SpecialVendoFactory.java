package backend;

public class SpecialVendoFactory implements VendoFactory {
    @Override
    public Vendo getNewVendo()
    {
        return new specialVendo();
    }
}
