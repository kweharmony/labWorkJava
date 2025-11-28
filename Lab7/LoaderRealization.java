public class LoaderRealization implements Runnable, Loader {
    private final Warehouse warehouse;

    public LoaderRealization(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    @Override
    public void carry() {
        try {
            Product item;
            while ((item = warehouse.getNextProduct()) != null) {
                warehouse.addItem(item);
            }
            warehouse.sendRemainingShipment();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void run() {
        carry();
    }
}