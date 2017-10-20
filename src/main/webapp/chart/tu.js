Chart.defaults.global.tooltips.custom = function(tooltip) {
	// Tooltip Element
	var tooltipEl = document.getElementById('chartjs-tooltip');

	// Hide if no tooltip
	if (tooltip.opacity === 0) {
		tooltipEl.style.opacity = 0;
		return;
	}

	// Set caret Position
	tooltipEl.classList.remove('above', 'below', 'no-transform');
	if (tooltip.yAlign) {
		tooltipEl.classList.add(tooltip.yAlign);
	} else {
		tooltipEl.classList.add('no-transform');
	}

	function getBody(bodyItem) {
		return bodyItem.lines;
	}

	// Set Text
	if (tooltip.body) {
		var titleLines = tooltip.title || [];
		var bodyLines = tooltip.body.map(getBody);

		var innerHtml = '<thead>';

		titleLines.forEach(function(title) {
			innerHtml += '<tr><th>' + title + '</th></tr>';
		});
		innerHtml += '</thead><tbody>';

		bodyLines.forEach(function(body, i) {
			var colors = tooltip.labelColors[i];
			var style = 'background:' + colors.backgroundColor;
			style += '; border-color:' + colors.borderColor;
			style += '; border-width: 2px';
			var span = '<span class="chartjs-tooltip-key" style="' + style
					+ '"></span>';
			innerHtml += '<tr><td>' + span + body + '</td></tr>';
		});
		innerHtml += '</tbody>';

		var tableRoot = tooltipEl.querySelector('table');
		tableRoot.innerHTML = innerHtml;
	}

	var positionY = this._chart.canvas.offsetTop;
	var positionX = this._chart.canvas.offsetLeft;

	// Display, position, and set styles for font
	tooltipEl.style.opacity = 1;
	tooltipEl.style.left = positionX + tooltip.caretX + 'px';
	tooltipEl.style.top = positionY + tooltip.caretY + 'px';
	tooltipEl.style.fontFamily = tooltip._fontFamily;
	tooltipEl.style.fontSize = tooltip.fontSize;
	tooltipEl.style.fontStyle = tooltip._fontStyle;
	tooltipEl.style.padding = tooltip.yPadding + 'px ' + tooltip.xPadding
			+ 'px';
};
window.config = {};
window.config1 = {};

function change() {
	$.getJSON("getValue.do", function(json) {
		var a, b, c, d, e, f, g, h;
		var a1, b1, c1, d1, e1, f1, g1, h1;
		a = typeof (json.男装) === "undefined" ? 0 : json.男装;
		b = typeof (json.女装) === "undefined" ? 0 : json.女装;
		c = typeof (json.男鞋) === "undefined" ? 0 : json.男鞋;
		d = typeof (json.女鞋) === "undefined" ? 0 : json.女鞋;
		e = typeof (json.袜品) === "undefined" ? 0 : json.袜品;
		f = typeof (json.家居) === "undefined" ? 0 : json.家居;
		g = typeof (json.童装) === "undefined" ? 0 : json.童装;
		h = typeof (json.内衣) === "undefined" ? 0 : json.内衣;
		a1 = a / (a + b + c + d + e + f + g + h) * 100 + "%";
		b1 = b / (a + b + c + d + e + f + g + h) * 100 + "%";
		c1 = c / (a + b + c + d + e + f + g + h) * 100 + "%";
		d1 = d / (a + b + c + d + e + f + g + h) * 100 + "%";
		e1 = e / (a + b + c + d + e + f + g + h) * 100 + "%";
		f1 = f / (a + b + c + d + e + f + g + h) * 100 + "%";
		g1 = g / (a + b + c + d + e + f + g + h) * 100 + "%";
		h1 = h / (a + b + c + d + e + f + g + h) * 100 + "%";

		window.config1 = {
			type : 'pie',
			data : {
				datasets : [ {
					data : [ a, b, c, d, e, f, g, h ],
					backgroundColor : [ window.chartColors.red,
							window.chartColors.orange,
							window.chartColors.yellow,
							window.chartColors.green, window.chartColors.blue,
							window.chartColors.purple, window.chartColors.gray,
							window.chartColors.hehe ],
				} ],
				labels : [ a1, b1, c1, d1, e1, f1, g1, h1 ]
			},
			options : {
				responsive : true,
				legend : {
					display : false
				},
				tooltips : {
					enabled : false,
				}
			}
		};
		window.config = {
			type : 'pie',
			data : {
				datasets : [ {
					data : [ a, b, c, d, e, f, g, h ],
					backgroundColor : [ window.chartColors.red,
							window.chartColors.orange,
							window.chartColors.yellow,
							window.chartColors.green, window.chartColors.blue,
							window.chartColors.purple, window.chartColors.gray,
							window.chartColors.hehe ],
				} ],
				labels : [ "男装", "女装", "男鞋", "女鞋", "袜品", "家居", "童装", "内衣" ]
			},
			options : {
				responsive : true,
				legend : {
					display : false
				},
				tooltips : {
					enabled : false,
				}
			}
		};
	});
}

$(function() {
	$("#msgmsg").fadeOut(5000);
	var ctx = document.getElementById("chart-area").getContext("2d");
	var ctx1 = document.getElementById("chart-area1").getContext("2d");

	change();
	new Chart(ctx, window.config);
	new Chart(ctx1, config1);
	window.timeid = setInterval(function() {
		$("#chart-area").empty();
		$("#chart-area1").empty();
		change();
		new Chart(ctx, window.config);
		new Chart(ctx1, config1);
	}, 5000);

});