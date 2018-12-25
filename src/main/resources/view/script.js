//model
var Blog=Backbone.Model.extend({
	defaults:{
		author:'',
		title:'',
		url:''
	}
});

var Blogs=Backbone.Collection.extend({});

/*var blog1=new Blog({
	author:'ravi',
	title:'gitangli',
	url:'http://www.rvai.com'
});
var blog2=new Blog({
	author:'sam',
	title:'nothing',
	url:'http://www.sam.com'
});

var blogs=new Blogs([blog1,blog2]);
*/
var BlogView=Backbone.View.extend({
	Model: new Blog(),
	tagName: 'tr',
	initialize: function(){
		this.template=_.template($('.list-template').html());
	},
	render:function(){
		this.$el.html(this.template({model:this.model.toJSON()}))
		return this;
	}
})

var BlogsView=Backbone.View.extend({
	Model: blogs,
	el: $el('.blog-list'),
	initialize: function(){
		this.model.on('add',this.render,this);
	},
	render: function(){
		var self=this,
		//this.$el.html('');
		_.each(this.model.toArray(),function(blog){
			self.$el.append((new BlogView({model:blog})).render().$el);
		})
		return this;
	}
})
var blogs=new BlogView();

$(document).ready(function(){
	$('add-btn').on('click',function(){
		var blog=new Blog({
			author:$('.auther_input').val(),
			title: $('.book_input').val(),
			url:$('.url_input').val()
		});
		console.log(blog);
		blogs.add(blog);
	})
})