jquery1_7_1(document)
		.ready(function() {
			// �������
				var accordion_head = jquery1_7_1('.accordion > li > a'); 
				var accordion_body = jquery1_7_1('#IndexAccordion ul > li > ul');
				//var accordion_body = jquery1_7_1('.accordion li > .sub-menu');
				// ��ʼ��
				accordion_head.first().addClass('active').next().slideDown(
						'normal');
				// ������¼���"click"����긡���ϡ�hover��
				accordion_head.on('hover', function(event) {
					// ���ر���
						event.preventDefault();
						// ������궯��չʾ�����ز˵�
						if (jquery1_7_1(this).attr('class') != 'active') {
							
							accordion_body.slideUp('normal');
							
							
							jquery1_7_1(this).next().stop(true, true)
									.slideToggle('normal');
							accordion_head.removeClass('active');
							jquery1_7_1(this).addClass('active');
						}
					});
			});