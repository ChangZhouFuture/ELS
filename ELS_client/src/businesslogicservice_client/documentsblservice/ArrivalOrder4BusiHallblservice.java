package businesslogicservice_client.documentsblservice;

import java.util.ArrayList;

import state.GoodState;
import state.ResultMessage;
import vo_client.documentsVO.ArrivalOrder4BusiHallVO;
import vo_client.documentsVO.DeliveryOrderVO;
import vo_client.lineitemVO.documentslineitemVO.ArrivalOrder4BusiHalllineitemVO;
import vo_client.lineitemVO.documentslineitemVO.DeliveryOrderlineitemVO;

/**
 * 
 * @author Öì¿¡ÎÄ
 * ´¦ÀíÓëÓªÒµÌüµ½´ïµ¥Ïà¹ØµÄÒµÎñÂß¼­
 *
 */
public interface ArrivalOrder4BusiHallblservice {
	/**
	 * ÒÑ´ò¿ªÓªÒµÌüµ½´ïµ¥ÊäÈëÒ³Ãæ
	 * Í¨¹ıÖĞ×ªµ¥ID»ñÈ¡³ö·¢µØ
	 * @param id
	 * @return ³ö·¢µØ
	 */
	public String getStartAddress(String id);
	
	/**
	 * ÒÑ´ò¿ªÓªÒµÌüµ½´ïµ¥ÊäÈëÒ³Ãæ
	 * ÅĞ¶ÏÖĞ×ªµ¥ÊÇ·ñ´æÔÚ
	 * @param id
	 * @return ÊÇ·ñ´æÔÚ
	 */
	public ResultMessage addTransferOrder(String id);
	
	/**
	 * ÒÑ´ò¿ªÓªÒµÌüµ½´ïµ¥ÊäÈëÒ³Ãæ
	 * ÏµÍ³×Ô¶¯·µ»ØÈÕÆÚ
	 * @return ÈÕÆÚ
	 */
	public String getDate();
	
	/**
	 * ÒÑ´ò¿ªÓªÒµÌüµ½´ïµ¥ÊäÈëÒ³Ãæ
	 * Ñ¡Ôñ»õÎï×´Ì¬
	 * @return »õÎïµ½´ï×´Ì¬
	 */
	public GoodState getGoodState();
	
	/**
	 * Ñ¡ÔñÔö¼ÓÓªÒµÌüµ½´ïµ¥
	 * Ôö¼ÓÒ»¸öÓªÒµÌüµ½´ïµ¥£¬¸üĞÂVO£¬PO£¬·µ»ØVOĞÅÏ¢µ½Õ¹Ê¾²ã
	 * @param id
	 * @param toid
	 * @param sa
	 * @param d
	 * @param gs
	 * @return Ò»¸öÓªÒµÌüµ½´ïµ¥
	 */
	public ArrivalOrder4BusiHallVO addArrivalOrder4BusiHall(String id,String toid,String sa,String d,String gs);
	
	/**
	 * Ç°ÖÃ£ºÒÑÑ¡ÔñĞÂÔöÓªÒµÌüµ½´ïµ¥²¢ÊäÈëÏà¹ØĞÅÏ¢
	 * ×Ô¶¯Éú³ÉÓªÒµÌüµ½´ïµ¥±àºÅ
	 * @return ÓªÒµÌüµ½´ïµ¥±àºÅ
	 */
	public String generateId();
	
	/**
	 * Ç°ÖÃ£ºÒÑÑ¡Ôñ¸ü¸ÄµÄÓªÒµÌüµ½´ïµ¥
	 * ¸ü¸ÄÒ»¸öÓªÒµÌüµ½´ïµ¥£¬¸üĞÂVO£¬PO£¬·µ»ØVOĞÅÏ¢µ½Õ¹Ê¾²ã
	  * @param id
	 * @param toid
	 * @param sa
	 * @param d
	 * @param gs
	 * @return ¸ü¸ÄºóµÄÓªÒµÌüµ½´ïµ¥
	 */
	public ArrivalOrder4BusiHallVO modify(String id,String toid,String sa,String d,String gs);
	
	/**
<<<<<<< HEAD
	 * Ç°ÖÃ£ºÆô¶¯Ò»¸öÓªÒµÌü½ÓÊÕ»ØºÏ
	 * É¾³ıÒ»¸öÓªÒµÌüµ½´ïµ¥
=======
	 * Ç°ÖÃ£ºÒªÉ¾³ıµÄÓªÒµÌüµ½´ïµ¥ÔÚ³Ö¾Ã»¯Êı¾İÖĞÓĞ¼ÇÂ¼
	 * ºóÖÃ£ºÉ¾³ıÒ»¸öÓªÒµÌüµ½´ïµ¥
<<<<<<< HEAD
>>>>>>> parent of a4837a0... dataæ¥å£åŠVOPOï¼ˆå·²å®Œæˆï¼‰
=======
>>>>>>> parent of a4837a0... dataæ¥å£åŠVOPOï¼ˆå·²å®Œæˆï¼‰
	 * @param id
	 */
	public void deleteone(String id);
	
	/**
<<<<<<< HEAD
	 * Ç°ÖÃ£ºÆô¶¯Ò»¸öÓªÒµÌü½ÓÊÕ»ØºÏ
	 * É¾³ı¶à¸öÓªÒµÌüµ½´ïµ¥
=======
	 * Ç°ÖÃ£ºÒªÉ¾³ıµÄÓªÒµÌüµ½´ïµ¥ÔÚ³Ö¾Ã»¯Êı¾İÖĞÓĞ¼ÇÂ¼
	 * ºóÖÃ£ºÉ¾³ı¶à¸öÓªÒµÌüµ½´ïµ¥
<<<<<<< HEAD
>>>>>>> parent of a4837a0... dataæ¥å£åŠVOPOï¼ˆå·²å®Œæˆï¼‰
=======
>>>>>>> parent of a4837a0... dataæ¥å£åŠVOPOï¼ˆå·²å®Œæˆï¼‰
	 * @param id
	 */
	public void deleteMany(ArrayList<String> id);
	
	/**
	 * Ç°ÖÃ£ºÆô¶¯Ò»¸öÓªÒµÌü½ÓÊÕ»ØºÏ
	 * Í¨¹ıID²éÕÒÄ³¸öÓªÒµÌüµ½´ïµ¥
	 * @param id
	 * @return ÓªÒµÌüµ½´ïµ¥ĞÅÏ¢
	 */
	public ArrivalOrder4BusiHallVO inquireA(String id);
	
	/**
	 * Ç°ÖÃ£ºÆô¶¯Ò»¸öÓªÒµÌü½ÓÊÕ»ØºÏ
	 * °´Ê±¼ä²éÕÒÓªÒµÌüµ½´ïµ¥ÁĞ±í
	 * @param time
	 * @return ÓªÒµÌüµ½´ïµ¥ÁĞ±í
	 */
	public ArrivalOrder4BusiHalllineitemVO inquireB(String time);
	
	/**
	 * Ç°ÖÃ£ºÒÑ×ö³öÔöÉ¾¸Ä²é²Ù×÷
	 * ½áÊø´Ë´ÎÓªÒµÌü½ÓÊÕ»ØºÏ£¬³Ö¾Ã»¯¸üĞÂÉè¼ÆµÄÁìÓò¶ÔÏóµÄÊı¾İ
	 */
	public void end();
}
