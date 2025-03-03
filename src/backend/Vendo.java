package backend;

public interface Vendo {
    public void setRecords(Record[] records);
    public Record[] getSellableRecords();
    public Record getItemRecord(Item item);

    class VendoFactory {
        public RegularVendo getRegularVendo()
        {
            return new RegularVendo();
        }

        public SpecialVendo getNewSpecialVendo()
        {
            return new SpecialVendo();
        }
    }
}
