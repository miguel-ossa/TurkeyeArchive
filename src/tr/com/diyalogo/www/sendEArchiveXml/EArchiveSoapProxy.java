package tr.com.diyalogo.www.sendEArchiveXml;

public class EArchiveSoapProxy implements tr.com.diyalogo.www.sendEArchiveXml.EArchiveSoap {
  private String _endpoint = null;
  private tr.com.diyalogo.www.sendEArchiveXml.EArchiveSoap eArchiveSoap = null;
  
  public EArchiveSoapProxy() {
    _initEArchiveSoapProxy();
  }
  
  public EArchiveSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initEArchiveSoapProxy();
  }
  
  private void _initEArchiveSoapProxy() {
    try {
      eArchiveSoap = (new tr.com.diyalogo.www.sendEArchiveXml.EArchiveLocator()).geteArchiveSoap();
      if (eArchiveSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)eArchiveSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)eArchiveSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (eArchiveSoap != null)
      ((javax.xml.rpc.Stub)eArchiveSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public tr.com.diyalogo.www.sendEArchiveXml.EArchiveSoap getEArchiveSoap() {
    if (eArchiveSoap == null)
      _initEArchiveSoapProxy();
    return eArchiveSoap;
  }
  
  public byte[] sendEArchiveXml(java.lang.String userId, java.lang.String password, java.lang.String XMLDocument) throws java.rmi.RemoteException{
    if (eArchiveSoap == null)
      _initEArchiveSoapProxy();
    return eArchiveSoap.sendEArchiveXml(userId, password, XMLDocument);
  }
  
  public java.lang.String sendEArchiveXml2(java.lang.String userId, java.lang.String password, java.lang.String XMLDocument) throws java.rmi.RemoteException{
    if (eArchiveSoap == null)
      _initEArchiveSoapProxy();
    return eArchiveSoap.sendEArchiveXml2(userId, password, XMLDocument);
  }
  
  
}