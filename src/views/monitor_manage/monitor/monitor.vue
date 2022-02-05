<template>
    <div>
        <page-header title="监控设置">
            <template #content>
                <div>
                    <div class="inLine">
                        <p class="hover" @click="back">返回上一页</p>
                    </div>
                    &nbsp;
                    <div>
                        此页为系统监控设置
                    </div>
                    <span>是否读取监控数据 </span>
                    <el-switch
                        v-model="pageMainShow"
                        active-text="开启"
                        inactive-text="关闭"
                        @click="handleSwitchChange"
                    />
                </div>
            </template>
        </page-header>
        <AbsoluteContainer>
            <page-main v-show="pageMainShow">
                <el-button type="primary">功能按钮位置</el-button>
                <el-table :data="pageDataList" border stripe highlight-current-row>
                    <el-table-column type="index" label="序列" width="50" />
                    <el-table-column prop="name" label="账户名称" width="100" />
                    <el-table-column prop="id" label="账户ID" width="150" />
                    <el-table-column prop="gid" label="值GID" width="150" />
                    <el-table-column prop="type" label="操作类型" width="150" />
                    <el-table-column prop="date" label="操作时间" width="150" />
                    <el-table-column prop="address" label="地址" />
                </el-table>
            </page-main>
        </AbsoluteContainer>
    </div>
</template>

<script>
import PageHeader from '@/components/PageHeader'
import PageMain from '@/components/PageMain'
export default {
    name: 'Monitor',
    components: {PageMain, PageHeader},
    data() {
        return {
            pageSwitchShow: true,
            pageMainShow: true,
            pageDataList: [
                {
                    date: '2022-01-02',
                    name: 'shellwe',
                    address: '广州市从化区广从南路548号'
                },
                {
                    date: '2022-01-04',
                    name: 'shellwe',
                    address: '广州市从化区广从南路548号'
                },
                {
                    date: '2022-01-01',
                    name: 'shellwe',
                    address: '广州市从化区广从南路548号'
                },
                {
                    date: '2022-01-03',
                    name: 'shellwe',
                    address: '广州市从化区广从南路548号'
                },
                {
                    date: '2022-01-04',
                    name: 'shellwe',
                    address: '广州市从化区广从南路548号'
                },
                {
                    date: '2022-01-01',
                    name: 'shellwe',
                    address: '广州市从化区广从南路548号'
                },
                {
                    date: '2022-01-03',
                    name: 'shellwe',
                    address: '广州市从化区广从南路548号'
                },
                {
                    date: '2022-01-04',
                    name: 'shellwe',
                    address: '广州市从化区广从南路548号'
                },
                {
                    date: '2022-01-01',
                    name: 'shellwe',
                    address: '广州市从化区广从南路548号'
                },
                {
                    date: '2022-01-03',
                    name: 'shellwe',
                    address: '广州市从化区广从南路548号'
                },
                {
                    date: '2022-01-04',
                    name: 'shellwe',
                    address: '广州市从化区广从南路548号'
                },
                {
                    date: '2022-01-01',
                    name: 'shellwe',
                    address: '广州市从化区广从南路548号'
                },
                {
                    date: '2022-01-03',
                    name: 'shellwe',
                    address: '广州市从化区广从南路548号'
                },
                {
                    date: '2022-01-04',
                    name: 'shellwe',
                    address: '广州市从化区广从南路548号'
                },
                {
                    date: '2022-01-01',
                    name: 'shellwe',
                    address: '广州市从化区广从南路548号'
                },
                {
                    date: '2022-01-03',
                    name: 'shellwe',
                    address: '广州市从化区广从南路548号'
                },
                {
                    date: '2022-01-03',
                    name: 'shellwe',
                    address: '广州市从化区广从南路548号'
                }
            ]
        }
    },
    mounted() {
        this.$nextTick(() => {
            // 获取表头高度，然后设置 .el-table__body-wrapper 的 height
            let height = document.getElementsByClassName('el-table__header-wrapper')[0].offsetHeight
            document.getElementsByClassName('el-table__body-wrapper')[0].style.height = `calc(90% - ${height}px)`
        })
    },
    methods: {
        back() {
            history.go(-1)
        },
        handleSwitchChange() {
            this.pageMainShow = !this.pageMainShow
            console.log(this.pageMainShow)
        }
    }
}
</script>

<style lang="scss" scoped>
.hover {
    cursor: pointer;
}
.page-main {
    display: flex;
    flex-direction: column;

    // 减去的 40px 为 page-main 的上下 margin
    // 减去的 130px 为 page-header 的高度，如果没有设置，可以去掉

    height: calc(100% - 40px - 130px);
    ::v-deep .el-table {
        height: 100%;
        .el-table__body-wrapper {
            overflow-y: auto;
        }
    }
}
</style>
