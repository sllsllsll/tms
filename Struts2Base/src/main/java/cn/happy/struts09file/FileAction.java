package cn.happy.struts09file;

import com.opensymphony.xwork2.Action;
import org.apache.struts2.ServletActionContext;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created by linlin on 2017/10/30.
 */
public class FileAction implements Action{

    private File upload;
    private String uploadContentType;
    private String uploadFileName;
    private String savePath;
    public String execute() throws Exception {
        byte[] buffer=new byte[1024];
        FileInputStream fis=new FileInputStream(getUpload());
        FileOutputStream fos=new FileOutputStream(getSavePath()+"\\"+getUploadFileName());
        int length=fis.read(buffer);
        while (length>0){
            fos.write(buffer,0,length);
            length=fis.read(buffer);
        }
        fos.flush();
        fos.close();
        fis.close();
        return SUCCESS;
    }

    public File getUpload() {
        return upload;
    }

    public void setUpload(File upload) {
        this.upload = upload;
    }

    public String getUploadContentType() {
        return uploadContentType;
    }

    public void setUploadContentType(String uploadContentType) {
        this.uploadContentType = uploadContentType;
    }

    public String getUploadFileName() {
        return uploadFileName;
    }

    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }

    public String getSavePath() {
        return ServletActionContext.getServletContext().getRealPath(savePath);
    }

    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }
}
