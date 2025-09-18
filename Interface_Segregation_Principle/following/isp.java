package following;

interface FileReader {
    void readFile();
}

interface FileWriter {
    void writeFile();
}

interface FileCompressor {
    void compressFile();
}

interface FileEncryptor {
    void encryptFile();
}

interface FileUploader {
    void uploadFile();
}

interface FileDownloader {
    void downloadFile();
}

// File viewer only implements what it needs
class FileViewer implements FileReader, FileDownloader {
    @Override
    public void readFile() {
        System.out.println("Reading file");
    }

    @Override
    public void downloadFile() {
        System.out.println("Downloading file");
    }
}

// File editor implements multiple interfaces as needed
class isp implements FileReader, FileWriter, FileCompressor, FileEncryptor {
    @Override
    public void readFile() {
        System.out.println("Reading file");
    }

    @Override
    public void writeFile() {
        System.out.println("Writing file");
    }

    @Override
    public void compressFile() {
        System.out.println("Compressing file");
    }

    @Override
    public void encryptFile() {
        System.out.println("Encrypting file");
    }
}

