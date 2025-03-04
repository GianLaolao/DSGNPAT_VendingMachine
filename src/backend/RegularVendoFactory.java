package backend;

public class RegularVendoFactory implements VendoFactory {

    @Override
    public Vendo getNewVendo()
    {
        return new RegularVendo();
    }

}
