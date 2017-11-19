package cn.happy.struts11down;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Created by linlin on 2017/11/5.
 */
public class FileDownAction extends ActionSupport {

    private String inputPath;
    private String fileName;
    private InputStream inputStream;
    private String contentType;

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }

    public String getInputPath() {
        return inputPath;
    }

    public void setInputPath(String inputPath) {
        this.inputPath = inputPath;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public InputStream getInputStream() throws FileNotFoundException {
        String path= ServletActionContext.getServletContext().getRealPath(inputPath);

        return new BufferedInputStream(new FileInputStream(path+"\\"+fileName));
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
}
