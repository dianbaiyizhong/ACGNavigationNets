jquery1_7_1(document)
		.ready(function() {
			// 定义变量
				var accordion_head = jquery1_7_1('.accordion > li > a'); 
				var accordion_body = jquery1_7_1('#IndexAccordion ul > li > ul');
				//var accordion_body = jquery1_7_1('.accordion li > .sub-menu');
				// 初始化
				accordion_head.first().addClass('active').next().slideDown(
						'normal');
				// 鼠标点击事件："click"；鼠标浮动上“hover”
				accordion_head.on('hover', function(event) {
					// 隐藏标题
						event.preventDefault();
						// 根据鼠标动作展示或隐藏菜单
						if (jquery1_7_1(this).attr('class') != 'active') {
							
							accordion_body.slideUp('normal');
							
							
							jquery1_7_1(this).next().stop(true, true)
									.slideToggle('normal');
							accordion_head.removeClass('active');
							jquery1_7_1(this).addClass('active');
						}
					});
			});