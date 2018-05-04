$(document).ready(function(){
	$(".datepicker").datepicker({
		changeMonth: true,
      	changeYear: true,
      	yearRange: '1926:c+1',
		monthNamesShort: ['Січень','Лютий','Березень',
					  'Квітень','Травень','Червень',
					  'Липень','Серпень','Вересень',
					  'Жовтень','Листопад','Грудень'],
		 dayNamesMin: ['Нд','Пн','Вт','Ср','Чт','Пт','Сб'],
		 showOn: "button",
      	 buttonImage: "images/calendar.gif",
      	 buttonImageOnly: true,
      	 minDate: new Date(1926, 10 - 1, 25),
      	 maxDate: '+30Y',
      	 //buttonText: "Select date",
 		 firstDay: 1,
 		 dateFormat: "dd.mm.yy"
	}).datepicker();
  });
