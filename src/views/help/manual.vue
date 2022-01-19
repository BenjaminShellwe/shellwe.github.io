<template>
    <div>
        <page-header title="使用手册">
            <template #content>
                <div class="inLine">
                    <p class="hover" @click="back">返回上一页</p>
                </div>
                &nbsp;
                <div class="inLine">
                    设计中
                </div>
            </template>
        </page-header>
        <page-main>
            本页面还在设计中<br>
            本页将再系统完成后开发,恕暂不提供浏览
            需要阅读临时手册请点击 <span @click="beenClick">➡此处⬅</span>
        </page-main>
    </div>
</template>

<script>
import PageHeader from '@/components/PageHeader'
import PageMain from '@/components/PageMain'
import router from '@/router'
export default {
    name: 'Manual',
    components: {PageMain, PageHeader},
    methods: {
        back() {
            history.go(-1)
        },
        beenClick() {
            router.push({path: '/multilevel_menu_basic/help/index'})
        }
    }
}
</script>
<style>
.hover {
    cursor: pointer;
}
</style>
