@objects
   aclensHeader		     css   				div.header-container
   logo				 	 css   				div.logo-container img
   ShoppedWithUsBefore	 css   				div.reorder-button-container span
   ReorderHere 			 css   				div.reorder-button-container a
   SelectionReorderBar   css   				div.lens-selection-reorder-bar
   FindYourContacts      css   				div.find-contacts-container span
   QuickSelectBar        css   				div.brand-quick-select-bar
   SocialFooter          css   				div.social-footer
   FollowUs				 css   				h3#social-links-title
   
	
  
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
	SelectionReorderBar:
		css background is "rgba(18, 87, 164, 1)"
	QuickSelectBar:
		height 55px to 65px
		below SelectionReorderBar
		css background-color is "rgb(238,238,238)"
	SocialFooter:
		css background-color is "rgb(238,238,238)"
	FollowUs:
		css color is "rgb(82,120,178)"
	

      
		
		