package violating;


/*
* " Clients should not be forces to depend upon interfaces that do not use."
*
* create focused client specific interfaces rather than large, general purpose interfaces.
*
* Interfaces should be more cohesive.
*
* How to identify ISP violation ?
* 1. large interefaces with many un related methods.
* 2. empty method implmentations or methods throwing UnsupportedOperationsExceptions.
* 3. classes implementing interefaces but only using subset of methods .
* 4. interfaces changes many affaecting unrelated classes.
* */
interface FileManager {
    void readFile();
    void writeFile();
    void compressFile();
    void encryptFile();
    void uploadFile();
    void downloadFile();
}

// Read-only file viewer forced to implement write operations
class isp implements FileManager {
    @Override
    public void readFile() {
        System.out.println("Reading file");
    }

    @Override
    public void writeFile() {
        throw new UnsupportedOperationException("Viewer cannot write");
    }

    @Override
    public void compressFile() {
        throw new UnsupportedOperationException("Viewer cannot compress");
    }

    @Override
    public void encryptFile() {

    }

    @Override
    public void uploadFile() {

    }

    @Override
    public void downloadFile() {

    }

    // ... other unsupported operations
}
