<!-- Code Explanation Ver 0.1 --by shellwe
"VEcharts" here is a bar or column table
The following code controls the vertical(xAxis) and vertical(yAxis) respectively.
"type" in "series" can input word "line" or "bar" for different view.
-->
<template>
    <div id="this-is-bar-chart" v-echarts="barChartOptions" class="chart" />
</template>

<script>
import VEcharts from 'vue-echarts-directive'
export default {
    name: 'VEcharts',
    directives: {
        'echarts': VEcharts
    },
    data() {
        return {
            barChartOptions: {
                tooltip: {},
                xAxis: {
                    data: ['A', 'B', 'C', 'D', 'E']
                },
                yAxis: {},
                series: [
                    {
                        name: 'Num',
                        type: 'line',
                        data: [5, 20, 36, 10, 10]
                    }
                ]
            }
        }
    }
}
</script>

<style scoped>
.chart {
    width: 400px;
    height: 400px;
}
</style>
