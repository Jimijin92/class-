class Ex08_Casting {

	public static void main(String[] args) {

		//Çüº¯È¯
		//1. ¾Ï½ÃÀûÀÎ Çüº¯È¯
		//2. ¸í½ÃÀûÀÎ Çüº¯È¯
		
		//Á¤¼ö -> Á¤¼ö
		
		byte b1 =10;	//¿øº»   1byte
		long l1 = 11;		//º¹»çº» 8byte
		
		//¾Ï½ÃÀûÀÎ Çüº¯È¯(¿øº»¼Õ½Çx)
		//l1 = b1;
		l1 = (long)b1;  //±ÇÀå

		System.out.println(l1);//º¹»çº» È®ÀÎ 		


        //½Ç¼öÇü
		float f1 =3.14f; //¿øº»// ¿¡·¯³ª´Â ÀÌÀ¯ ¿ŞÂÊÀº 8 ¿À¸¥ÂÊÀº 4 /Å«°Ô ÀÛÀºµ¥·Î /±×·²¶© ¸í½ÃÀûÀÎ Çüº¯È¯ ÇÊ¿ä/¿ø·¡ (float)3.14
		double d1;       // º¹»çº»
		
		//floatÀ» doble·Î ¹Ù²Ù°Å³ª ±× ¹İ´ë´Â º¸Åë Àß ¾ÈÇÔ
		//¾Ï½ÃÀûÀÎ Çüº¯È¯
		d1 =f1;

		System.out.println(d1);
		//Å° ¸ÅÅ©·Î 
	    
		double d2 = 1.23456789012345; //¿øº»
		float f2; //º¹»çº»
		System.out.println(d2); 
		
		f2 = (float)d2;
		System.out.println(f2);	


		//½Ç¼ö <-> Á¤¼ö
		double d3 = 3.14;   //3.99·Î ÇÏ¸é 4°¡ µÇ´ÂÁö ¾Æ´Ï¸é ¾Æ¿¹¹ö¸®´ÂÁö È®ÀÎ ²ÀÇÏ±â // »óÈ²µû¶ó ´Ù¸§
		int n3;

		//?
		n3 = (int)d3; //¹«Á¶°Ç ¹ö¸² //¸í½ÃÀû Çüº¯È¯ ÇÊ¿ä

		System.out.println(n3);

		float f4 = 3.14F;
		long l4;

		//Å«Çü(8) = ÀÛÀºÇü(4)// ¼ıÀÚ ÀÚÃ¼´Â 8¹ÙÀÌÆ®, 4¹ÙÀÌÆ®Áö¸¸ ¹üÀ§´Â ¿ŞÂÊÇ×ÀÌ ÈÎ¾À Å©´Ù ±×·¡¼­ ¸í½ÃÀûÀ¸·Î ÇØÁà¾ßÇÔ
		//¼öÀÇ ¹üÀ§(o), ¹ÙÀÌÆ® Å©±â(x)-> Á¤¼öÇü°ú ½Ç¼öÇü °æ¿ì¿¡ 
	
		l4 = (long)f4;
		
		System.out.println(l4);


		//±âº»ÇüÀÇ ¹üÀ§ ºñ±³  (StirngÀº ÂüÁ¶ÇüÀ¸·Î ¹Ø¿¡ ¾ÖµéÀÌ¶û µÚ¼¯À» ¼ö°¡ ¾øÀ½)
		//byte(1) < short(2) < int(4) < long(8) < float(4) < double(8)
		//			char(2)
		//boolean(1)

		//** ±âº»Çü°ú ÂüÁ¶Çü³¢¸®´Â º¯È¯ÀÌ ºÒ°¡´É(¸Ş¸ğ¸® ±¸Á¶ ‹š¹®¿¡..)

		//booleanÀº Çüº¯È¯ÀÇ ´ë»óÀÌ µÉ ¼ö ¾ø´Ù.
		// (int)true; <- ÀÌ·±°Å ¾ø´Ù


		//¹®ÀÚÇü
		// - 'A' -> 65 (¹®ÀÚÄÚµå°ªÀÌ¶ó ºÒ¸®´Â Á¤¼ö¿ÍÀÇ ÀüÈ¯¸¸ °¡´ÉÇÏ´Ù)
		char c5 = '°¡'; //2byte ¡Ú¡Ú¡Ú¡Ú¡ÚA´ë½Å '°¡'¸¦ ³ÖÀ¸¸é -21504 ³ª¿È ÄÄÆÄÀÏ ¿¡·¯¾øÀÌ ±×·¡¼­ short ¾È¾¸
		                // char´Â ºÎÈ£ºñÆ®°¡ ¾øÀ½, ¾çÀÇ Á¤¼ö¹Û¿¡ ¾øÀ½ ¼ıÀÚ´Ï±î ±×·¡¼­ 4¸¸´ë±îÁö Ç¥Çö°¡´ÉÇÏÁö¸¸ short´Â 3¸¸´ë±îÁö¹Û¿¡ Ç¥ÇöÀÌ ¾ÈµÊ -> int»ç¿ë 
		short s5; //2byte

		//¼ıÀÚ = ¹®ÀÚ
		s5 = (short)c5;

		System.out.println(s5);

		System.out.println((char)66);


		char c6 = '°¡'; // 2byte
		int n6; //4byte

		n6 = c6;

		System.out.println(n6);

		
		int n7 = 65;
		char c7 = '5';

	    System.out.println(n7);
		System.out.println((int)c7);

		System.out.println((int)'A');//65
		System.out.println((int)'Z');//90
		System.out.println((int)'a');//97
		System.out.println((int)'z');//122
		System.out.println((int)'0');//48
		System.out.println((int)'9');//57

		System.out.println((int)'°¡');//ÇÑ±ÛÀÇ ½ÃÀÛ
		System.out.println((int)'ÆR');//ÇÑ±ÛÀÇ ³¡







			}

}
