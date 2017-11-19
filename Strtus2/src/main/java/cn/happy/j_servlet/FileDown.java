package cn.happy.j_servlet;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import java.io.*;

/**
 * Created by linlin on 2017/10/8.
 */
public class FileDown extends ActionSupport{

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
