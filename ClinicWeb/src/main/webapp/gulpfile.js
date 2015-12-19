// Include gulp
var gulp = require('gulp');

// Include Our Plugins
var jshint = require('gulp-jshint');
var sass = require('gulp-sass');
var concat = require('gulp-concat');
var uglify = require('gulp-uglify');
var rename = require('gulp-rename');
var coffee = require('gulp-coffee');
var haml = require('gulp-ruby-haml');
var serve = require('gulp-serve');
var mainBowerFiles = require('main-bower-files');
var vendor = require('gulp-concat-vendor');
var filter = require('gulp-filter');

gulp.task('bower-files', function() {
    return gulp.src(mainBowerFiles(), { base: './bower_components' })
      .pipe(filter('**/*.js'))
      .pipe(concat('bower.js'))
      .pipe(gulp.dest('assets/js/bower'));
});
// Lint Task
gulp.task('lint', function() {
    return gulp.src('assets/**/*.js')
        .pipe(jshint())
        .pipe(jshint.reporter('default'));
});

// Compile Our Sass
gulp.task('sass', function() {
    return gulp.src('assets/sass/*.sass')
        .pipe(sass())
        .pipe(gulp.dest('assets/css'));
});

//Compile coffee
gulp.task('coffee', function() {
  return gulp.src('./app/**/*.coffee')
    .pipe(coffee())
    .pipe(gulp.dest('assets/js'));
});

gulp.task('css', function() {
  return gulp.src(mainBowerFiles(['**/*.css']), { base: './bower_components' })
    .pipe(gulp.dest('assets/css/bower'));
});

gulp.task('haml-double-quote', function() {
  gulp.src('index.haml')
       .pipe(haml())
       .pipe(gulp.dest(function(file) {
         return file.base;
       }));
});

gulp.task('haml-double-quote-view', function() {
  gulp.src('./app/**/*.haml')
       .pipe(haml())
       .pipe(gulp.dest(function(file) {
         return file.base;
       }));
});

// Concatenate & Minify JS
gulp.task('scripts', function() {
    return gulp.src(['assets/js/bower/**/*.js', 'assets/js/*.js', 'assets/js/components/**/*.js', 'assets/js/shared/**/*.js'])
        .pipe(filter('**/*.js'))
        .pipe(concat('all.js'))
        .pipe(gulp.dest('dist'));
        //.pipe(rename('all.min.js'))
        //.pipe(uglify())
        //.pipe(gulp.dest('dist'));
});

gulp.task('css-concat', function(){
  return gulp.src(['assets/css/bower/**/*.css', 'assets/css/*.css'])
    .pipe(concat('all.css'))
    .pipe(gulp.dest('dist'));
});
// Watch Files For Changes
gulp.task('watch', function() {
  gulp.watch('./bower_components', ['bower-files']);
	gulp.watch('index.haml', ['haml-double-quote']);
  gulp.watch('./app/**/*.haml', ['haml-double-quote-view']);
	gulp.watch('./app/**/*.coffee', ['coffee']);
  gulp.watch('assets/js/*.js', ['scripts']);
  gulp.watch('assets/sass/*.sass', ['sass']);
  gulp.watch('assets/css/**/*.css', ['css-concat']);
});

// Default Task
gulp.task('default', ['serve', 'bower-files', 'haml-double-quote', 'haml-double-quote-view', 'coffee', 'css', 'sass', 'css-concat', 'scripts', 'watch']);

gulp.task('serve', serve('.'));
