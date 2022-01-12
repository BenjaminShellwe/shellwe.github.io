<template>
    <div>
        <page-header title="使用手册">
            <template #content>
                <div class="inLine">
                    <p @click="back">返回上一页</p>
                </div>
                &nbsp;
                <div class="inLine">
                    此页为系统使用手册
                </div>
            </template>
        </page-header>
        <page-main>
            本页面还在设计中
        </page-main>
    </div>
</template>

<script>
import PageHeader from '@/components/PageHeader'
import PageMain from '@/components/PageMain'
export default {
    name: 'Manual',
    components: {PageMain, PageHeader},
    methods: {
        back() {
            history.go(-1)
        }
    }
}
</script>
