@objects
	acl_promo_header						xpath				div[class='acl-header__promo']
	new_customer_offer_text					xpath				//span[contains(text(),'New Customer Offer')]
	on_all_contact_lense_text				xpath				//span[contains(text(),'On All Contact Lenses*')]
	search_box								css					input#searchText-944813327
	product_matching_text              		xpath				//h2[contains(text(),'Products matching your search for')]
	sort_text								xpath				//label[contains(text(),'Sort:')]
	sort_type_dropdown						css					select#sortTypesortType
	result_for_page_text					css					div.pull-right.hidden-xs span.results-per-page-text
	page_size_drop_down						css					div.pull-right.hidden-xs select.page-size-dropdown
	product_img								css					span.shelf__panel--image--wrap img
	product_name							css					span.shelf__panel--name
	free_shipping_banner			        css					div.free-shipping-banner.row.hidden-xs
	follow_us								css					h3#social-links-title
	faceBook_icon							css					span.icon-facebook5
	instagram_icon							css					span.icon-instagram2
	twitter_icon							css					span.icon-twitter4
	never_miss_text							xpath				//span[contains(text(),'Never miss a sale!')]
	email_text_button						css					input#email-signup-input
	chat_text_container						css					span.chatReturnTop__chatTextContainer
	
	
	
=Main Section=
	acl_promo_header:
		count any acl_promo_header is 1
	new_customer_offer_text:
		css font-size is "16px"
		count any new_customer_offer_text is 1
		color-scheme <6% #214185
	on_all_contact_lense_text:
		css font-size is "13.3px"
		count any on_all_contact_lense_text is 1 
		color-scheme <6% #214185
	search_box:
		count any search_box is 1
	product_matching_text:
		width 570px
		height 20px
		count any product_matching_text is 1
		css font-size is "18px"
	sort_text:
		width 30px
		height 16px
		count any sort_text is 1
		css font-size is "14px"
	sort_type_dropdown:
		count any sort_type_dropdown is 1
	result_for_page_text:
		below sort_text
		count any result_for_page_text is 1
		css font-size is "12px"
	page_size_drop_down:
		width 80px
		height 35px
		count any page_size_drop_down is 1 
	product_img:
		width 310px
		height 206px
		count any product_img is 1
	product_name:			
		below product_img
		width 310px
		height 18px
		count any product_img is 1
	free_shipping_banner:
		count any free_shipping_banner is 1
	instagram_icon: 
		css font-size is "26px"
		count any instagram_icon is 1
	twitter_icon:
		css font-size is "26px"
		count any twitter_icon is 1
	never_miss_text: 
		css font-size is "16px"
		width 116px
		height 18px
		count any never_miss_text is 1
	email_text_button:
		width 215px
		height 34px
		count any email_text_button is 1
	chat_text_container:
		width 160px
		height 54px
		count any email_text_button is 1
	follow_us:
		below free_shipping_banner
		css font-size is "18.72px"
		count any follow_us is 1