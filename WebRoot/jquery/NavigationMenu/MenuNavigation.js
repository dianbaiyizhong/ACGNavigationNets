
jquery1_9_1(function() {
	var speed = 200;
	jquery1_9_1('#NavigationMenu_SAO>li').mouseenter(function() {
		jquery1_9_1(this).find('ul').stop(false, true).slideDown(speed);
	}).mouseleave(function() {
		jquery1_9_1(this).find('ul').stop(false, true).slideUp(speed);
	});
});



