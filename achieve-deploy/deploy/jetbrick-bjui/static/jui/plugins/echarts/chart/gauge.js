define("echarts/chart/gauge", ["require", "../component/base", "./base", "../util/shape/GaugePointer", "zrender/shape/Text", "zrender/shape/Line", "zrender/shape/Rectangle", "zrender/shape/Circle", "zrender/shape/Sector", "../config", "../util/ecData", "../util/accMath", "zrender/tool/util", "../chart"], function (e) {
    function t(e, t, a, o, s) {
        n.call(this, e, t, a, o, s), i.call(this), this.refresh(o)
    }

    var n = e("../component/base"), i = e("./base"), a = e("../util/shape/GaugePointer"), o = e("zrender/shape/Text"), s = e("zrender/shape/Line"), r = e("zrender/shape/Rectangle"), l = e("zrender/shape/Circle"), h = e("zrender/shape/Sector"), m = e("../config"), V = e("../util/ecData"), U = e("../util/accMath"), d = e("zrender/tool/util");
    return t.prototype = {
        type: m.CHART_TYPE_GAUGE, _buildShape: function () {
            var e = this.series;
            this._paramsMap = {};
            for (var t = 0, n = e.length; n > t; t++)e[t].type === m.CHART_TYPE_GAUGE && (e[t] = this.reformOption(e[t]), this.legendHoverLink = e[t].legendHoverLink || this.legendHoverLink, this._buildSingleGauge(t), this.buildMark(t));
            this.addShapeList()
        }, _buildSingleGauge: function (e) {
            var t = this.series[e];
            this._paramsMap[e] = {
                center: this.parseCenter(this.zr, t.center),
                radius: this.parseRadius(this.zr, t.radius),
                startAngle: t.startAngle.toFixed(2) - 0,
                endAngle: t.endAngle.toFixed(2) - 0
            }, this._paramsMap[e].totalAngle = this._paramsMap[e].startAngle - this._paramsMap[e].endAngle, this._colorMap(e), this._buildAxisLine(e), this._buildSplitLine(e), this._buildAxisTick(e), this._buildAxisLabel(e), this._buildPointer(e), this._buildTitle(e), this._buildDetail(e)
        }, _buildAxisLine: function (e) {
            var t = this.series[e];
            if (t.axisLine.show)for (var n, i, a = t.min, o = t.max - a, s = this._paramsMap[e], r = s.center, l = s.startAngle, h = s.totalAngle, m = s.colorArray, U = t.axisLine.lineStyle, d = this.parsePercent(U.width, s.radius[1]), p = s.radius[1], c = p - d, u = l, y = 0, g = m.length; g > y; y++)i = l - h * (m[y][0] - a) / o, n = this._getSector(r, c, p, i, u, m[y][1], U), u = i, n._animationAdd = "r", V.set(n, "seriesIndex", e), V.set(n, "dataIndex", y), this.shapeList.push(n)
        }, _buildSplitLine: function (e) {
            var t = this.series[e];
            if (t.splitLine.show)for (var n, i, a, o = this._paramsMap[e], r = t.splitNumber, l = t.min, h = t.max - l, m = t.splitLine, V = this.parsePercent(m.length, o.radius[1]), U = m.lineStyle, d = U.color, p = o.center, c = o.startAngle * Math.PI / 180, u = o.totalAngle * Math.PI / 180, y = o.radius[1], g = y - V, b = 0; r >= b; b++)n = c - u / r * b, i = Math.sin(n), a = Math.cos(n), this.shapeList.push(new s({
                zlevel: this._zlevelBase + 1,
                hoverable: !1,
                style: {
                    xStart: p[0] + a * y,
                    yStart: p[1] - i * y,
                    xEnd: p[0] + a * g,
                    yEnd: p[1] - i * g,
                    strokeColor: "auto" === d ? this._getColor(e, l + h / r * b) : d,
                    lineType: U.type,
                    lineWidth: U.width,
                    shadowColor: U.shadowColor,
                    shadowBlur: U.shadowBlur,
                    shadowOffsetX: U.shadowOffsetX,
                    shadowOffsetY: U.shadowOffsetY
                }
            }))
        }, _buildAxisTick: function (e) {
            var t = this.series[e];
            if (t.axisTick.show)for (var n, i, a, o = this._paramsMap[e], r = t.splitNumber, l = t.min, h = t.max - l, m = t.axisTick, V = m.splitNumber, U = this.parsePercent(m.length, o.radius[1]), d = m.lineStyle, p = d.color, c = o.center, u = o.startAngle * Math.PI / 180, y = o.totalAngle * Math.PI / 180, g = o.radius[1], b = g - U, f = 0, k = r * V; k >= f; f++)f % V !== 0 && (n = u - y / k * f, i = Math.sin(n), a = Math.cos(n), this.shapeList.push(new s({
                zlevel: this._zlevelBase + 1,
                hoverable: !1,
                style: {
                    xStart: c[0] + a * g,
                    yStart: c[1] - i * g,
                    xEnd: c[0] + a * b,
                    yEnd: c[1] - i * b,
                    strokeColor: "auto" === p ? this._getColor(e, l + h / k * f) : p,
                    lineType: d.type,
                    lineWidth: d.width,
                    shadowColor: d.shadowColor,
                    shadowBlur: d.shadowBlur,
                    shadowOffsetX: d.shadowOffsetX,
                    shadowOffsetY: d.shadowOffsetY
                }
            })))
        }, _buildAxisLabel: function (e) {
            var t = this.series[e];
            if (t.axisLabel.show)for (var n, i, a, s, r = t.splitNumber, l = t.min, h = t.max - l, m = t.axisLabel.textStyle, V = this.getFont(m), d = m.color, p = this._paramsMap[e], c = p.center, u = p.startAngle, y = p.totalAngle, g = p.radius[1] - this.parsePercent(t.splitLine.length, p.radius[1]) - 10, b = 0; r >= b; b++)s = U.accAdd(l, U.accMul(U.accDiv(h, r), b)), n = u - y / r * b, i = Math.sin(n * Math.PI / 180), a = Math.cos(n * Math.PI / 180), n = (n + 360) % 360, this.shapeList.push(new o({
                zlevel: this._zlevelBase + 1,
                hoverable: !1,
                style: {
                    x: c[0] + a * g,
                    y: c[1] - i * g,
                    color: "auto" === d ? this._getColor(e, s) : d,
                    text: this._getLabelText(t.axisLabel.formatter, s),
                    textAlign: n >= 110 && 250 >= n ? "left" : 70 >= n || n >= 290 ? "right" : "center",
                    textBaseline: n >= 10 && 170 >= n ? "top" : n >= 190 && 350 >= n ? "bottom" : "middle",
                    textFont: V,
                    shadowColor: m.shadowColor,
                    shadowBlur: m.shadowBlur,
                    shadowOffsetX: m.shadowOffsetX,
                    shadowOffsetY: m.shadowOffsetY
                }
            }))
        }, _buildPointer: function (e) {
            var t = this.series[e];
            if (t.pointer.show) {
                var n = t.max - t.min, i = t.pointer, o = this._paramsMap[e], s = this.parsePercent(i.length, o.radius[1]), r = this.parsePercent(i.width, o.radius[1]), h = o.center, m = this._getValue(e);
                m = m < t.max ? m : t.max;
                var U = (o.startAngle - o.totalAngle / n * (m - t.min)) * Math.PI / 180, d = "auto" === i.color ? this._getColor(e, m) : i.color, p = new a({
                    zlevel: this._zlevelBase + 1,
                    style: {
                        x: h[0],
                        y: h[1],
                        r: s,
                        startAngle: o.startAngle * Math.PI / 180,
                        angle: U,
                        color: d,
                        width: r,
                        shadowColor: i.shadowColor,
                        shadowBlur: i.shadowBlur,
                        shadowOffsetX: i.shadowOffsetX,
                        shadowOffsetY: i.shadowOffsetY
                    },
                    highlightStyle: {brushType: "fill", width: r > 2 ? 2 : r / 2, color: "#fff"}
                });
                V.pack(p, this.series[e], e, this.series[e].data[0], 0, this.series[e].data[0].name, m), this.shapeList.push(p), this.shapeList.push(new l({
                    zlevel: this._zlevelBase + 2,
                    hoverable: !1,
                    style: {x: h[0], y: h[1], r: i.width / 2.5, color: "#fff"}
                }))
            }
        }, _buildTitle: function (e) {
            var t = this.series[e];
            if (t.title.show) {
                var n = t.data[0], i = null != n.name ? n.name : "";
                if ("" !== i) {
                    var a = t.title, s = a.offsetCenter, r = a.textStyle, l = r.color, h = this._paramsMap[e], m = h.center[0] + this.parsePercent(s[0], h.radius[1]), V = h.center[1] + this.parsePercent(s[1], h.radius[1]);
                    this.shapeList.push(new o({
                        zlevel: this._zlevelBase + (Math.abs(m - h.center[0]) + Math.abs(V - h.center[1])) < 2 * r.fontSize ? 2 : 1,
                        hoverable: !1,
                        style: {
                            x: m,
                            y: V,
                            color: "auto" === l ? this._getColor(e) : l,
                            text: i,
                            textAlign: "center",
                            textFont: this.getFont(r),
                            shadowColor: r.shadowColor,
                            shadowBlur: r.shadowBlur,
                            shadowOffsetX: r.shadowOffsetX,
                            shadowOffsetY: r.shadowOffsetY
                        }
                    }))
                }
            }
        }, _buildDetail: function (e) {
            var t = this.series[e];
            if (t.detail.show) {
                var n = t.detail, i = n.offsetCenter, a = n.backgroundColor, o = n.textStyle, s = o.color, l = this._paramsMap[e], h = this._getValue(e), m = l.center[0] - n.width / 2 + this.parsePercent(i[0], l.radius[1]), V = l.center[1] + this.parsePercent(i[1], l.radius[1]);
                this.shapeList.push(new r({
                    zlevel: this._zlevelBase + (Math.abs(m + n.width / 2 - l.center[0]) + Math.abs(V + n.height / 2 - l.center[1])) < o.fontSize ? 2 : 1,
                    hoverable: !1,
                    style: {
                        x: m,
                        y: V,
                        width: n.width,
                        height: n.height,
                        brushType: "both",
                        color: "auto" === a ? this._getColor(e, h) : a,
                        lineWidth: n.borderWidth,
                        strokeColor: n.borderColor,
                        shadowColor: n.shadowColor,
                        shadowBlur: n.shadowBlur,
                        shadowOffsetX: n.shadowOffsetX,
                        shadowOffsetY: n.shadowOffsetY,
                        text: this._getLabelText(n.formatter, h),
                        textFont: this.getFont(o),
                        textPosition: "inside",
                        textColor: "auto" === s ? this._getColor(e, h) : s
                    }
                }))
            }
        }, _getValue: function (e) {
            var t = this.series[e].data[0];
            return null != t.value ? t.value : t
        }, _colorMap: function (e) {
            var t = this.series[e], n = t.min, i = t.max - n, a = t.axisLine.lineStyle.color;
            a instanceof Array || (a = [[1, a]]);
            for (var o = [], s = 0, r = a.length; r > s; s++)o.push([a[s][0] * i + n, a[s][1]]);
            this._paramsMap[e].colorArray = o
        }, _getColor: function (e, t) {
            null == t && (t = this._getValue(e));
            for (var n = this._paramsMap[e].colorArray, i = 0, a = n.length; a > i; i++)if (n[i][0] >= t)return n[i][1];
            return n[n.length - 1][1]
        }, _getSector: function (e, t, n, i, a, o, s) {
            return new h({
                zlevel: this._zlevelBase,
                hoverable: !1,
                style: {
                    x: e[0],
                    y: e[1],
                    r0: t,
                    r: n,
                    startAngle: i,
                    endAngle: a,
                    brushType: "fill",
                    color: o,
                    shadowColor: s.shadowColor,
                    shadowBlur: s.shadowBlur,
                    shadowOffsetX: s.shadowOffsetX,
                    shadowOffsetY: s.shadowOffsetY
                }
            })
        }, _getLabelText: function (e, t) {
            if (e) {
                if ("function" == typeof e)return e.call(this.myChart, t);
                if ("string" == typeof e)return e.replace("{value}", t)
            }
            return t
        }, refresh: function (e) {
            e && (this.option = e, this.series = e.series), this.backupShapeList(), this._buildShape()
        }
    }, d.inherits(t, i), d.inherits(t, n), e("../chart").define("gauge", t), t
}), define("echarts/util/shape/GaugePointer", ["require", "zrender/shape/Base", "zrender/tool/util", "./normalIsCover"], function (e) {
    function t(e) {
        n.call(this, e)
    }

    var n = e("zrender/shape/Base"), i = e("zrender/tool/util");
    return t.prototype = {
        type: "gauge-pointer", buildPath: function (e, t) {
            var n = t.r, i = t.width, a = t.angle, o = t.x - Math.cos(a) * i * (i >= n / 3 ? 1 : 2), s = t.y + Math.sin(a) * i * (i >= n / 3 ? 1 : 2);
            a = t.angle - Math.PI / 2, e.moveTo(o, s), e.lineTo(t.x + Math.cos(a) * i, t.y - Math.sin(a) * i), e.lineTo(t.x + Math.cos(t.angle) * n, t.y - Math.sin(t.angle) * n), e.lineTo(t.x - Math.cos(a) * i, t.y + Math.sin(a) * i), e.lineTo(o, s)
        }, getRect: function (e) {
            if (e.__rect)return e.__rect;
            var t = 2 * e.width, n = e.x, i = e.y, a = n + Math.cos(e.angle) * e.r, o = i - Math.sin(e.angle) * e.r;
            return e.__rect = {
                x: Math.min(n, a) - t,
                y: Math.min(i, o) - t,
                width: Math.abs(n - a) + t,
                height: Math.abs(i - o) + t
            }, e.__rect
        }, isCover: e("./normalIsCover")
    }, i.inherits(t, n), t
});