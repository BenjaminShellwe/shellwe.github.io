<template>
    <div>
        <page-header title="企业招聘门户">
            <template #content>
                <div>
                    <div class="hover" @click="back">返回上一页&nbsp;&nbsp;</div>
                    <div class="inLine">此页面设置控制企业招聘门户网页</div>
                </div>
            </template>
        </page-header>
        <page-main>
            单独设计
            此处连续管理页面的功能都是差不多的,但是由于对改功能模块的具体功用不熟悉,之后会继续完善
        </page-main>
    </div>
</template>

<script>
import PageMain from '@/components/PageMain'
export default {
    name: 'Enterprise',
    components: {PageMain},
    data() {
        return {

        }
    },
    methods: {
        back() {
            history.go(-1)
        }
    }
}
</script>

