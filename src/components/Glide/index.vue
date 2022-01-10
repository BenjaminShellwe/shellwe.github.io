<!-- Code Explanation Ver 0.1 --by shellwe
"Glide" here is swipeable chart "VEcharts"'s carrier
The following traversed code controls the number of display columns. Default is 6
Only one line can be swiped.
-->
<template>
    <vue-glide>
        <vue-glide-slide v-for="i in 6" :key="i">
            <V_Echarts />
            SlidName {{ i }}
        </vue-glide-slide>
    </vue-glide>
</template>

<script>
import 'vue-glide-js/dist/vue-glide.css'
import V_Echarts from '@/components/VEcharts'
import {Glide, GlideSlide} from 'vue-glide-js'
export default {
    name: 'Glide',
    components: {
        V_Echarts,
        [Glide.name]: Glide,
        [GlideSlide.name]: GlideSlide
    }
}
</script>
