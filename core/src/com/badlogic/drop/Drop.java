package com.badlogic.drop;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;

public class Drop extends ApplicationAdapter {
	//Рисует текстуры на экране
	private SpriteBatch batch1;

	//Размер шара
	private int ball_size = 100;

	//Список текстур шариков(красный, оранжевый и т.д)
	private Array<Texture> ballsIMGS = new Array<>();
	//Список прямоугольников шариков
	private Array<Rectangle> balls = new Array<>();

	//Текстура колбы
	private Texture flaskIMG;

	//Прямоугольник для колбы(моделька)
	private Rectangle flask = new Rectangle();

	//Камера мира
	private OrthographicCamera camera;


	//Сделаем колбу которая состоит из 5 прямоугольников(квадратов)
	private Array<Rectangle> squares_of_flask = new Array<Rectangle>();


	private int count_balls = 0;


	@Override
	public void create () {
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 400);

		for(int i = 0; i < 4;i++) {
			squares_of_flask.add(new Rectangle(800/ 2 - 64/2, i* ball_size + 20, ball_size, ball_size));
		}

		flask.x = 800 / 2 - 64 /2;
		flask.y = 20;

		batch1 = new SpriteBatch();


		flaskIMG = new Texture(Gdx.files.internal("img/colb/colb.png"));
		ballsIMGS.add(new Texture(Gdx.files.internal("img/balls/greenball.png")));
		ballsIMGS.add(new Texture(Gdx.files.internal("img/balls/purple_ball.png")));
		ballsIMGS.add(new Texture(Gdx.files.internal("img/balls/orange_ball.png")));
		ballsIMGS.add(new Texture(Gdx.files.internal("img/balls/pink_ball.png")));
		ballsIMGS.add(new Texture(Gdx.files.internal("img/balls/light_blue_ball.png")));
		ballsIMGS.add(new Texture(Gdx.files.internal("img/balls/red_ball.png")));
		ballsIMGS.add(new Texture(Gdx.files.internal("img/balls/blueball.png")));
		ballsIMGS.add(new Texture(Gdx.files.internal("img/balls/yellowball.png")));

		for (int i =0; i< 4; i++) {
			balls.add(new Rectangle(0, ball_size * i, ball_size, ball_size));
		}
		for (int i =4; i< 8; i++) {
			balls.add(new Rectangle(ball_size, ball_size * (i -4), ball_size, ball_size));
		}
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(255,255,255,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		camera.update();
		batch1.setProjectionMatrix(camera.combined);

		batch1.begin();
		ScreenRenderer screenRenderer = new ScreenRenderer(batch1);
		screenRenderer.drawBalls(ballsIMGS, balls, ball_size);
		
		batch1.draw(flaskIMG, flask.x, flask.y);
		batch1.end();


		if (Gdx.input.isTouched()) {
			int x = Gdx.input.getX();
			int y = Gdx.input.getY();
			if (balls.get(0).contains(x, y)) {

			}
		}
	}
	
	@Override
	public void dispose () {
		batch1.dispose();
		for (Texture ball: ballsIMGS
			 ) {
			ball.dispose();

		}
	}

	public void addToFlask(Texture ball) {
		if (count_balls != 5)  {
			batch1.begin();
			batch1.draw(ball, balls.get(count_balls).x, balls.get(count_balls).y);
			batch1.end();
			count_balls++;
		}
	}
}
