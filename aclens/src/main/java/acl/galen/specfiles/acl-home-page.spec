@objects
   aclensHeader		     css   				div.header-container
   logo				 	 css   				div.logo-container img
   ShoppedWithUsBefore	 css   				div.reorder-button-container span
   ReorderHere 			 css   				div.reorder-button-container a
   SelectionReorderBar   css   				div.lens-selection-reorder-bar
   FindYourContacts      css   				div.find-contacts-container span
   QuickSelectBar        css   				div.brand-quick-select-bar

   
	
  
= HomePage = 
	ShoppedWithUsBefore:
		inside SelectionReorderBar
		css font-size is "20px"
		left-of ReorderHere	
	ReorderHere:
		inside SelectionReorderBar
		width 220px
		css font-size is "14px"
		right-of ShoppedWithUsBefore
	FindYourContacts:
		inside SelectionReorderBar
		css font-size is "20px"
		right-of ReorderHere
	QuickSelectBar:
		below SelectionReorderBar
	

      
		
		