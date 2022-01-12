<template>
    <div>
        <page-header title="系统日志">
            <template #content>
                <div class="inLine">
                    <p @click="back">返回上一页</p>
                </div>
                &nbsp;
                <div class="inLine">
                    此页为系统日志设置
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
    name: 'Log',
    components: {PageMain, PageHeader},
    methods: {
        back() {
            history.go(-1)
        }
    }
}
</script>
