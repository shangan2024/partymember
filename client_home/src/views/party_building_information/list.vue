<template>
	<div class="diy_list page_party_building_information" id="party_building_information_list">
		<div class="warp">
			<div class="container diy_list_container">
				<div class="diy_list_title">
					<div class="col">
						<span class="title">党建资讯列表</span>
					</div>
				</div>
				<div class="row diy_list_search">
					<div class="col">
						<!-- 搜索栏 -->
						<div class="view">
							<span class="diy_list_search_title">关键字搜索：</span>
								<b-form-input size="sm" class="mr-sm-2" placeholder="资讯标题搜索" v-model="query['information_title']" />
									<b-form-input size="sm" class="mr-sm-2" placeholder="资讯类型搜索" v-model="query['information_type']" />
									<b-form-input size="sm" class="mr-sm-2" placeholder="管理者姓名搜索" v-model="query['manager_name']" />
												<b-button size="sm" @click="search()" >
								<b-icon icon="search"/>
							</b-button>
						</div>
						<!-- /搜索栏 -->
					</div>
				</div>
				<div class="diy_list_select_box">
					<span class="diy_list_select_title">下拉搜索：</span>
						<div class="diy_list_dropdown_box">
						<div class="col">
							<!-- 筛选 -->
							<div class="view">
																			<b-dropdown text="管理者姓名" variant="outline-dark" left>
									<b-dropdown-item @click="filter_set('全部','manager_name')">全部</b-dropdown-item>
									<b-dropdown-item v-for="o in list_manager_name" :key="o['user_id']" @click="filter_set(o['user_id'],'manager_name')">
										{{ o['nickname'] + '-' + o['username'] }}
									</b-dropdown-item>
								</b-dropdown>
														</div>
							<!-- /筛选 -->
						</div>
					</div>
					<div class="diy_list_sort_box">
						<div class="col">
							<!-- 排序 -->
							<div class="view">
								<b-dropdown text="排序" variant="outline-dark" left>
										<b-dropdown-item v-for="(o, i) in list_sort" :key="i" @click="set_sort(o)" >
												{{ o.name }}
										</b-dropdown-item>
								</b-dropdown>
							</div>
							<!--/排序 -->
						</div>
					</div>
				</div>

				<div class="row diy_list_box">
					<div class="col">
						<!-- 列表 -->
						<list_party_building_information :list="list" />
						<!-- /列表 -->
					</div>
				</div>
				<div class="row diy_list_page_box">
					<div class="col overflow-auto flex_cc">
						<!-- 分页器 -->
<!--						<diy_pager v-model="query['page']" :size="query['size']" :count="count" v-on:toPage="toPage" v-on:toSize="toSize" ></diy_pager>-->
            <b-pagination
                v-model="query.page"
                :total-rows="count"
                :per-page="query.size"
                @change="goToPage"
            />
						<!-- /分页器 -->
					</div>
				</div>
			</div>
		</div>
	</div>
</template>

<script>
	import list_party_building_information from "@/components/diy/list_party_building_information.vue";
	import diy_pager from "@/components/diy/diy_pager";
	import mixin from "@/mixins/page.js";

	export default {
		mixins: [mixin],
		components: {
			diy_pager,
			list_party_building_information
		},
		data() {
			return {
				url_get_list: "~/api/party_building_information/get_list?like=0",

				// 查询条件
				query: {
					keyword: "",
					page: 1,
					size: 10,
								"information_title": "", // 资讯标题
											"information_type": "", // 资讯类型
											"manager_name": 0, // 管理者姓名
											},

				// 排序内容
				list_sort: [{
						name: "创建时间从高到低",
						value: "create_time desc",
					},
					{
						name: "创建时间从低到高",
						value: "create_time asc",
					},
					{
						name: "更新时间从高到低",
						value: "update_time desc",
					},
					{
						name: "更新时间从低到高",
						value: "update_time asc",
					},
						{
						name: "资讯标题正序",
						value: "information_title asc",
					},
					{
						name: "资讯标题倒序",
						value: "information_title desc",
					},
							{
						name: "资讯类型正序",
						value: "information_type asc",
					},
					{
						name: "资讯类型倒序",
						value: "information_type desc",
					},
							{
						name: "管理者姓名正序",
						value: "manager_name asc",
					},
					{
						name: "管理者姓名倒序",
						value: "manager_name desc",
					},
									],

										list_manager_name: [],
									
			}
		},
		methods: {
      get_list_before(param) {
      },
			/**
			 * 筛选选择
			 */
			filter_set(o,key) {
			    if (o == "全部") {
			        this.query[key] = "";
			    } else {
			        this.query[key] = o;
			    }
			    this.search();
			},

			/**
			 * 排序
			 */
			set_sort(o) {
			    this.query.orderby = o.value;
			    this.search();
			},


							
			/**
			 * 筛选
			 */
																				/**
			 * 获取管理者姓名列表
			 */
			async get_list_manager_name() {
				var json = await this.$get("~/api/user/get_list?user_group=普通管理者");
				if(json.result && json.result.list){
					this.list_manager_name = json.result.list;
				}
				else if(json.error){
					console.error(json.error);
				}
			},
										/**
			 * 重置
			 */
			reset() {
							this.query.information_title = ""
										this.query.information_type = ""
										this.query.manager_name = ""
											this.search();
			},

			// 返回条数
			toSize(i){
				this.query.size = i;
				this.first();
			},

			// 返回页数
			toPage(i){
				this.query.page = i;
				this.first();
			},

      goToPage(v){
        this.query.page = v;
        this.goToNew(v)
      },

		},
		computed: {
		},
		created() {
									this.get_list_manager_name();
											}
	}
</script>

<style>
</style>
