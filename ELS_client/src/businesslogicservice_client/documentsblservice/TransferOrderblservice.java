package businesslogicservice_client.documentsblservice;

import java.util.ArrayList;

import state.ResultMessage;
import state.TransportType;
import vo_client.documentsVO.TransferOrderVO;
import vo_client.lineitemVO.documentslineitemVO.TransferOrderlineitemVO;

/**
 * 
 * @author Öì¿¡ÎÄ
 * ´¦ÀíÓëÖĞ×ªµ¥Ïà¹ØµÄÒµÎñÂß¼­
 *
 */
public interface TransferOrderblservice {
	
	/**
	 * ÒÑ´ò¿ªÖĞ×ªµ¥ÊäÈëÒ³Ãæ
	 * ÖĞ×ªÖĞĞÄÊÇ·ñ´æÔÚ
	 * @param tcid
	 * @return ÊÇ·ñ´æÔÚ
	 */
	public ResultMessage addTransferCenter(String tcid);
	
	/**
	 * ÒÑ´ò¿ªÖĞ×ªµ¥ÊäÈëÒ³Ãæ
	 * Ôö¼Ó¶©µ¥
	 * @param orderid
	 * @return 
	 */
	public ArrayList<String> addOrder(String orderid);
	
	/**
	 * ÒÑ´ò¿ªÖĞ×ªµ¥ÊäÈëÒ³Ãæ
	 * ÏµÍ³×Ô¶¯·µ»ØÈÕÆÚ
	 * @return ÈÕÆÚ
	 */
	public String getDate();
	
	/**
	 * ÒÑÊäÈë³ö·¢µØÄ¿µÄµØ
	 * ÏµÍ³×Ô¶¯¼ÆËãÔË·Ñ
	 * @param sa
	 * @param ea
	 * @return ÔË·Ñ
	 */
<<<<<<< HEAD
	public int getFare(String sa,String ea);
=======
	public int generateFare(String sa,String ea);
>>>>>>> parent of a4837a0... dataæ¥å£åŠVOPOï¼ˆå·²å®Œæˆï¼‰
	/**
	 * Ñ¡ÔñÔö¼ÓÖĞ×ªµ¥
	 * Ôö¼ÓÒ»¸öÖĞ×ªµ¥£¬¸üĞÂVO£¬PO£¬·µ»ØVOĞÅÏ¢µ½Õ¹Ê¾²ã
	 * @param id
	 * @param tst
	 * @param sa
	 * @param ea
	 * @param orderidlist
	 * @param d
	 * @param hbid
	 * @param hgid
	 * @param Jzy
	 * @return Ò»¸öÖĞ×ªµ¥
	 */
	public TransferOrderVO addTransferOrder(String id,TransportType tst,String sa,String ea,ArrayList<String> orderidlist,String d,String hbid,String hgid,String Jzy);
	
	/**
	 * Ç°ÖÃ£ºÒÑÑ¡ÔñĞÂÔöÖĞ×ªµ¥²¢ÊäÈëÏà¹ØĞÅÏ¢
	 * ×Ô¶¯Éú³ÉÖĞ×ªµ¥±àºÅ
	 * @return ÖĞ×ªµ¥±àºÅ
	 */
	public String generateId();
	
	/**
	 * Ç°ÖÃ£ºÒÑÑ¡Ôñ¸ü¸ÄµÄÖĞ×ªµ¥
	 * ¸ü¸ÄÒ»¸öÖĞ×ªµ¥£¬¸üĞÂVO£¬PO£¬·µ»ØVOĞÅÏ¢µ½Õ¹Ê¾²ã
	 * @param id
	 * @param tst
	 * @param sa
	 * @param ea
	 * @param orderidlist
	 * @param d
	 * @param hbid
	 * @param hgid
	 * @param Jzy
	 * @return ¸ü¸ÄºóµÄÖĞ×ªµ¥
	 */
	public TransferOrderVO modify(String id,TransportType tst,String sa,String ea,ArrayList<String> orderidlist,String d,String hbid,String hgid,String Jzy);
	
	/**
	 * Ç°ÖÃ£ºÆô¶¯Ò»¸öÖĞ×ª»ØºÏ
	 * É¾³ıÒ»¸öÖĞ×ªµ¥
	 * @param id
	 */
	public void deleteone(String id);
	
	/**
	 * Ç°ÖÃ£ºÆô¶¯Ò»¸öÖĞ×ª»ØºÏ
	 * É¾³ı¶à¸öÖĞ×ªµ¥
	 * @param id
	 */
	public void deleteMany(ArrayList<String> id);
	
	/**
	 * Ç°ÖÃ£ºÆô¶¯Ò»¸öÖĞ×ª»ØºÏ
	 * Í¨¹ıID²éÕÒÄ³¸öÖĞ×ªµ¥
	 * @param id
	 * @return ÖĞ×ªµ¥ĞÅÏ¢
	 */
	public TransferOrderVO inquireA(String id);
	
	/**
	 * Ç°ÖÃ£ºÆô¶¯Ò»¸öÖĞ×ª»ØºÏ
	 * °´Ê±¼ä²éÕÒÖĞ×ªµ¥ÁĞ±í
	 * @param time
	 * @return ÖĞ×ªµ¥ÁĞ±í
	 */
	public TransferOrderlineitemVO inquireB(String time);
	
	/**
	 * Ç°ÖÃ£ºÒÑ×ö³öÔöÉ¾¸Ä²é²Ù×÷
	 * ½áÊø´Ë´ÎÖĞ×ª»ØºÏ£¬³Ö¾Ã»¯¸üĞÂÉè¼ÆµÄÁìÓò¶ÔÏóµÄÊı¾İ
	 */
	public void end();
}
