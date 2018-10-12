package com.study.android.test2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class Search extends YouTubeBaseActivity {
    private static final String TAG = "lecture";

    TextView textView5;
    TextView textView7;

    YouTubePlayerView youTubeView;
    YouTubePlayer.OnInitializedListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        youTubeView = (YouTubePlayerView)findViewById(R.id.youtubeView);
        //리스너 등록부분

        textView5 = findViewById(R.id.textView5);
        textView7 = findViewById(R.id.textView7);
        Intent intent = getIntent();

        String singer = intent.getStringExtra("singer");
        String songname = intent.getStringExtra("songname");
        String age2 = intent.getStringExtra("age");
        int age = Integer.parseInt(age2);

        textView5.setText(age + ". " + singer + " - " + songname);
            switch (age){
                case 1 : list1();
                    break;
                case 2 : list2();
                    break;
                case 3 : list3();
                    break;
                case 4 : list4();
                    break;
                case 5 : list5();
                    break;
                case 6 : list6();
                    break;
                case 7 : list7();
                    break;
                case 8 : list8();
                    break;
                case 9 : list9();
                    break;
                case 10 : list10();
                    break;
                case 11 : list11();
                    break;
                case 12 : list12();
                    break;
                case 13 : list13();
                    break;
                case 14 : list14();
                    break;
                case 15 : list15();
                    break;
                case 16 : list16();
                    break;
                case 17 : list17();
                    break;
                case 18 : list18();
                    break;
                case 19 : list19();
                    break;
                case 20 : list20();
                    break;
                default: defaultt();
                    break;
            }
    }

    public void list1(){
        listener = new YouTubePlayer.OnInitializedListener(){
            //초기화 성공시
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo("6dUXyVJeK6w");//url의 맨 뒷부분 ID값만 넣으면 됨
            }
            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
            }
        };
        youTubeView.initialize("AIzaSyBLovcPCxpM1MDswgO7gtwRceVD2vy7odA", listener);
        textView7.setText("새하얀 머플러에 얼굴을 묻고\n" +
                "붉어진 눈을 깜빡이며 널 기다렸어\n" +
                "무슨 얘길 하고 픈지 그 말\n" +
                "알 것도 같은데 모르겠어\n" +
                "어색한 눈인사에 목이 메이고\n" +
                "한 발 물러 선\n" +
                "우리 둘 공간에 눈물 터지고\n" +
                "화가 나서 소리치듯 가란 내 말에\n" +
                "벌써 넌 아주 멀리 달아나 버렸어\n" +
                "오늘 헤어졌어요 우리 헤어졌어요\n" +
                "내 맘 알 것 같다면\n" +
                "옆에서 같이 울어줘요\n" +
                "나는 안되나봐요 역시 아닌가봐요\n" +
                "얼마나 더 울어야 제대로 사랑 할까요\n" +
                "\n" +
                "귓가엔 심장소리 그대 울리고\n" +
                "지운 니 번호 지울수록\n" +
                "더욱 또렷 해지고\n" +
                "언제부터 어디부터 멀어진 건지\n" +
                "분명히 어제까진 날 사랑 했는데\n" +
                "오늘 헤어졌어요 우리 헤어졌어요\n" +
                "내 맘 알 것 같다면\n" +
                "옆에서 같이 울어줘요\n" +
                "나는 안되나봐요 역시 아닌가봐요\n" +
                "얼마나 더 울어야 제대로 사랑 할까요\n" +
                "참 좋았어 너무 좋아서 더 아프죠\n" +
                "사랑에 또 속은 내가 미워\n" +
                "\n" +
                "그냥 나오지 말 걸 그냥 아프다 할 걸\n" +
                "우리 사랑한 기억\n" +
                "그게 널 붙잡아 줄 텐데\n" +
                "너는 내일을 살고 나는 오늘을 살아\n" +
                "아무도 아무것도 날 웃게할 수는 없어\n" +
                "오늘 헤어졌어요 우리 헤어졌어요\n" +
                "내 맘 알 것 같다면\n" +
                "옆에서 같이 울어줘요\n" +
                "나는 안되나봐요 역시 아닌가봐요\n" +
                "얼마나 더 울어야 제대로 사랑 할까요");
    }

    public void list2(){
        listener = new YouTubePlayer.OnInitializedListener(){
            //초기화 성공시
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo("xRbPAVnqtcs");//url의 맨 뒷부분 ID값만 넣으면 됨
            }
            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
            }
        };
        youTubeView.initialize("AIzaSyBLovcPCxpM1MDswgO7gtwRceVD2vy7odA", listener);
        textView7.setText("저 오늘 떠나요 공항으로\n" +
                "핸드폰 꺼 놔요\n" +
                "제발 날 찾진 말아줘\n" +
                "시끄럽게 소리를 질러도\n" +
                "어쩔 수 없어 나\n" +
                "가볍게 손을 흔들며 bye bye\n" +
                "쉬지 않고 빛났던 꿈같은\n" +
                "my youth\n" +
                "이리저리 치이고 또 망가질 때쯤\n" +
                "지쳤어 나 미쳤어\n" +
                "나 떠날 거야 다 비켜\n" +
                "I fly away\n" +
                "Take me to London\n" +
                "Paris New York city들\n" +
                "아름다운 이 도시에 빠져서 나\n" +
                "Like I'm a bird bird\n" +
                "날아다니는 새처럼\n" +
                "난 자유롭게 fly fly\n" +
                "나 숨을 셔\n" +
                "Take me to new world anywhere\n" +
                "어디든\n" +
                "답답한 이 곳을 벗어 나기만 하면\n" +
                "Shining light light\n" +
                "빛나는 my youth\n" +
                "자유롭게 fly fly\n" +
                "나 숨을 셔\n" +
                "저 이제 쉬어요 떠날 거예요 \n" +
                "노트북 꺼 놔요\n" +
                "제발 날 잡진 말아줘\n" +
                "시끄럽게 소리를 질러도\n" +
                "어쩔 수 없어 나\n" +
                "가볍게 손을 흔들며 see ya\n" +
                "쉬지 않고 빛났던 꿈같은\n" +
                "my youth\n" +
                "이리 저리 치이고 또 망가질 때쯤\n" +
                "지쳤어 나 미쳤어\n" +
                "나 떠날 거야 다 비켜\n" +
                "I fly away\n" +
                "Take me to London Paris\n" +
                "New York city들\n" +
                "아름다운 이 도시에 빠져서 나\n" +
                "Like I'm a bird bird\n" +
                "날아 다니는 새처럼\n" +
                "난 자유롭게 fly fly\n" +
                "나 숨을 셔\n" +
                "Take me to new world anywhere\n" +
                "어디든\n" +
                "답답한 이 곳을 벗어 나기만 하면\n" +
                "Shining light light\n" +
                "빛나는 my youth\n" +
                "자유롭게 fly fly\n" +
                "나 숨을 셔\n" +
                "I can fly away\n" +
                "Fly always always always\n" +
                "Take me to new world anywhere\n" +
                "어디든\n" +
                "답답한 이 곳을 벗어 나기만 하면\n" +
                "Shining light light\n" +
                "빛나는 my youth\n" +
                "자유롭게 fly fly\n" +
                "나 숨을 셔");
    }

    public void list3(){
        listener = new YouTubePlayer.OnInitializedListener(){
            //초기화 성공시
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo("eHir_vB1RUI");//url의 맨 뒷부분 ID값만 넣으면 됨
            }
            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
            }
        };
        youTubeView.initialize("AIzaSyBLovcPCxpM1MDswgO7gtwRceVD2vy7odA", listener);
        textView7.setText("텅 빈 회색 빛 거린 참 허전해\n" +
                "쓸쓸한 기분에 유리창을 열어\n" +
                "내민 두 손 위로 떨어진 빗방울\n" +
                "가득 고이는 그리움 나의 맘에 흘러\n" +
                "왠지 네가 보고픈 밤\n" +
                "차오르는 눈물\n" +
                "떠오르는 나의 맘 속\n" +
                "비가 오면 내리는 기억에\n" +
                "번지는 아픔에\n" +
                "흠뻑 쏟아지는 너를 보다\n" +
                "선명했던 그 시간에 멈춘 채\n" +
                "추억에 젖은 채\n" +
                "아름다웠던 너를 그려 in the Rain\n" +
                "길었던 참 눈이 부셨던 계절도\n" +
                "사진첩 속에 얼룩져 색이 바래질까\n" +
                "점점 깊어가는 이 밤\n" +
                "잊지 못한 약속\n" +
                "따뜻했던 품도 안녕\n" +
                "비가 오면 내리는 기억에\n" +
                "번지는 아픔에\n" +
                "흠뻑 쏟아지는 너를 보다\n" +
                "선명했던 그 시간에 멈춘 채\n" +
                "추억에 젖은 채\n" +
                "아름다웠던 너를 그려 in the Rain\n" +
                "흑백뿐인 세상 속\n" +
                "한줄기의 빛이 돼준 너\n" +
                "Rain 비가 되어 다가와\n" +
                "내 영혼을 환히 밝혀줘\n" +
                "Doo doo doo doo doo doo doo\n" +
                "Doo doo doo doo doo doo doo\n" +
                "Doo doo doo doo doo doo doo\n" +
                "Doo doo doo doo doo doo doo\n" +
                "Doo doo doo doo doo doo doo\n" +
                "Doo doo doo doo doo doo doo\n" +
                "Woo Woo Woo who who who \n" +
                "우산 아래 나직했던 속삭임 Woo Woo \n" +
                "가슴 한 켠에 퍼져 네가 들려\n" +
                "오늘 하루 내 안부를 묻듯이\n" +
                "편안한 빗소리\n" +
                "아련히 물든 기억 너란 빗속에\n" +
                "Woo Woo rain Woo\n" +
                "Dreaming in the Rain");
    }

    public void list4(){
        listener = new YouTubePlayer.OnInitializedListener(){
            //초기화 성공시
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo("WMkVnGfd8uQ");//url의 맨 뒷부분 ID값만 넣으면 됨
            }
            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
            }
        };
        youTubeView.initialize("AIzaSyBLovcPCxpM1MDswgO7gtwRceVD2vy7odA", listener);
        textView7.setText("바람을 타고 날아오르는 \n" +
                "새들은 걱정없이 \n" +
                "아름다운 태양속으로 \n" +
                "음표가 되어 나네 \n" +
                "향기나는 연필로 쓴 \n" +
                "일기처럼 \n" +
                "숨겨두었던 마음 \n" +
                "기댈수 있는 \n" +
                "어깨가 있어 \n" +
                "비가 와도 젖지 않아 \n" +
                "어제의 일들은 잊어 \n" +
                "누구나 조금씩은 틀려 \n" +
                "완벽한 사람은 없어 \n" +
                "실수투성이고 \n" +
                "외로운 나를 봐 \n" +
                "난 다시 \n" +
                "태어난 것만 같아 \n" +
                "그대를 만나고부터 \n" +
                "그대 나의 \n" +
                "초라한 마음을 \n" +
                "받아준 순간부터 \n" +
                "랄랄랄랄랄 \n" +
                "\n" +
                "하루 하루 \n" +
                "조금씩 나아질거야 \n" +
                "그대가 지켜보니 \n" +
                "힘을 내야지 \n" +
                "행복해져야지 \n" +
                "뒷뜰에 핀 꽃들처럼 \n" +
                "점심을 함께 먹어야지 \n" +
                "새로 연 그 가게에서 \n" +
                "새 샴푸를 사러가야지 \n" +
                "아침 하늘빛의 \n" +
                "민트 향이면 어떨까 \n" +
                "난 다시 \n" +
                "꿈을 꾸게 되었어 \n" +
                "그대를 만나고부터 \n" +
                "그대 나의 초라한 \n" +
                "마음을 받아준 순간부터 \n" +
                "\n" +
                "월요일도 화요일도 \n" +
                "봄에도 겨울에도 \n" +
                "해가 질 무렵에도 \n" +
                "비둘기를 안은 \n" +
                "아이같이 \n" +
                "행복해줘 나를 위해서 \n" +
                "난 다시 \n" +
                "태어난 것만 같아 \n" +
                "그대를 만나고부터 \n" +
                "그대 나의 초라한 \n" +
                "마음을 \n" +
                "받아준 순간부터 \n" +
                "난 다시 \n" +
                "꿈을 꾸게 되었어 \n" +
                "그대를 만나고부터 \n" +
                "그대 나의 초라한 \n" +
                "마음을 받아준 순간부터 \n" +
                "랄랄랄랄랄 \n" +
                "랄랄랄랄랄랄랄 \n" +
                "랄랄랄랄랄 \n" +
                "랄랄랄랄랄랄랄 우~ \n" +
                "랄랄랄랄랄 \n" +
                "랄랄랄랄랄랄랄랄랄 \n" +
                "우~ ");
    }

    public void list5(){
        listener = new YouTubePlayer.OnInitializedListener(){
            //초기화 성공시
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo("Fm5iP0S1z9w");//url의 맨 뒷부분 ID값만 넣으면 됨
            }
            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
            }
        };
        youTubeView.initialize("AIzaSyBLovcPCxpM1MDswgO7gtwRceVD2vy7odA", listener);
        textView7.setText("라라라라라라라 라라라라라라라\n" +
                "You and me in the moonlight\n" +
                "별 꽃 축제 열린 밤\n" +
                "파도 소리를 틀고 춤을 추는 이 순간\n" +
                "이 느낌 정말 딱야\n" +
                "바다야 우리와 같이 놀아\n" +
                "바람아 너도 이쪽으로 와\n" +
                "달빛 조명 아래서 너와 나와 세상과\n" +
                "다 같이 Party all night long yeah\n" +
                "it’s good\n" +
                "If you wanna have some fun\n" +
                "짭짤한 공기처럼 이 순간의 특별한\n" +
                "행복을 놓치지마\n" +
                "One two three let’s go\n" +
                "저 우주 위로 날아갈 듯 춤추러 가\n" +
                "Hey Let’s dance the night away\n" +
                "Let’s dance the night away\n" +
                "One two three let’s go\n" +
                "저 바다 건너 들릴 듯 소리 질러\n" +
                "let’s dance the night away\n" +
                "Dance the night away\n" +
                "Let’s dance the night away\n" +
                "Dance the night away\n" +
                "Let’s dance the night away\n" +
                "You and me in this cool night\n" +
                "미소 짓는 반쪽 달\n" +
                "그 언젠가 너와 나 저 달 뒷면으로 가\n" +
                "파티를 열기로 약속\n" +
                "yeah it’s good\n" +
                "If you wanna have some fun\n" +
                "은빛 모래알처럼 이 순간의 특별한\n" +
                "행복을 놓치지 마\n" +
                "One two three let’s go\n" +
                "저 우주 위로 날아갈 듯 춤추러 가\n" +
                "Hey Let’s dance the night away\n" +
                "Let’s dance the night away\n" +
                "One two three let’s go\n" +
                "저 바다 건너 들릴 듯 소리 질러\n" +
                "let’s dance the night away\n" +
                "오늘이 마지막인 듯\n" +
                "소리 질러 저 멀리\n" +
                "끝없이 날아오를 듯\n" +
                "힘껏 뛰어 더 높이\n" +
                "오늘이 마지막인 듯\n" +
                "소리 질러 저 멀리\n" +
                "쏟아지는 별빛과\n" +
                "Let’s dance the night away\n" +
                "Let’s dance the night away\n" +
                "One two three let’s go\n" +
                "저 바다 건너 들릴 듯 소리 질러\n" +
                "let’s dance the night away\n" +
                "Let’s dance the night away\n" +
                "Dance the night away\n" +
                "Dance the night away\n" +
                "Dance the night away\n" +
                "Let’s dance the night away");
    }

    public void list6(){
        listener = new YouTubePlayer.OnInitializedListener(){
            //초기화 성공시
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo("wzGKTOQ5D2I");//url의 맨 뒷부분 ID값만 넣으면 됨
            }
            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
            }
        };
        youTubeView.initialize("AIzaSyBLovcPCxpM1MDswgO7gtwRceVD2vy7odA", listener);
        textView7.setText("다 식어 버린 커피\n" +
                "넌 이런 느낌 모르겠지 예\n" +
                "또 떠올리기 싫어\n" +
                "더 차갑던 너의 눈빛\n" +
                "언제 깨져버린 건지\n" +
                "남아있는 작은 유리 파편\n" +
                "다시 마음이 찔려도\n" +
                "괜찮을까 이젠 정말\n" +
                "달콤하게 먼저 왜곡된 추억도\n" +
                "지우려해 Baby\n" +
                "힘들지않아 또 하루가 너없이도\n" +
                "반복되고\n" +
                "눈물이 흘러\n" +
                "모두 지나가고\n" +
                "이제 끝난 걸 알지만\n" +
                "또 추억이 흘러\n" +
                "계속 숨을 쉬고\n" +
                "잠도 잘자고 있는걸\n" +
                "너 없이도 화려한 거리\n" +
                "너 없이도 따스한 공기\n" +
                "눈물이 흘러 오늘도\n" +
                "Oh Don't Hurt Anymore\n" +
                "연락 없는 phone\n" +
                "아마도 넌 아무것도\n" +
                "아닌듯 보낼거 같아보여 uh\n" +
                "Baby I just wanna know\n" +
                "너도 나와 같은 길에서\n" +
                "똑같이 힘들어 하고 있는 지\n" +
                "wait wait\n" +
                "목이 말러\n" +
                "What’s the problem\n" +
                "물론 말론 괜찮지만\n" +
                "벌써 너의 집 앞까지 왔어\n" +
                "문틈 사이 전해오는 너의 향기에\n" +
                "금방이라도 문이 열릴것만 같지 왜\n" +
                "Baby I’ll be there\n" +
                "마음속에 깊이 박혔던 상처도\n" +
                "어루만져줘 Baby\n" +
                "슬프지 않아 또 하루가 흘러가고\n" +
                "예전처럼\n" +
                "눈물이 흘러\n" +
                "모두 지나가고\n" +
                "이제 끝난 걸 알지만\n" +
                "또 추억이 흘러\n" +
                "계속 숨을 쉬고\n" +
                "잠도 잘자고 있는걸\n" +
                "너 없이도 화려한 거리\n" +
                "너 없이도 따스한 공기\n" +
                "눈물이 흘러 오늘도\n" +
                "Oh Don't Hurt Anymore\n" +
                "Heart break 다 겪는 일이야\n" +
                "내 눈물처럼 번지는건 싫어\n" +
                "이 모습대로 시간이 흘러도\n" +
                "다 지나가는거야\n" +
                "눈물이 흘러\n" +
                "모두 지나가고\n" +
                "이제 끝난 걸 알지만\n" +
                "또 추억이 흘러\n" +
                "계속 숨을 쉬고\n" +
                "잠도 잘자고 있는걸\n" +
                "너 없이도 화려한 거리\n" +
                "너 없이도 따스한 공기\n" +
                "눈물이 흘러 오늘도\n" +
                "Oh Don't Hurt Anymore\n" +
                "시간이 흘러 아무렇지 않게\n" +
                "시간이 흘러 아무렇지 않게\n" +
                "시간이 흘러 아무의미 없게\n" +
                "Oh Don't Hurt Anymore");
    }

    public void list7(){
        listener = new YouTubePlayer.OnInitializedListener(){
            //초기화 성공시
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo("S10azlzvS_8");//url의 맨 뒷부분 ID값만 넣으면 됨
            }
            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
            }
        };
        youTubeView.initialize("AIzaSyBLovcPCxpM1MDswgO7gtwRceVD2vy7odA", listener);
        textView7.setText("한 겹 두 겹 칠해져 가네\n" +
                "여기저기 새겨져 가네\n" +
                "계속 나를 칠해줘\n" +
                "White 네가 없던 그때의 나는\n" +
                "캔버스처럼 새하얬었지\n" +
                "외롭긴 했지만 평화롭던 일상\n" +
                "그랬지 항상\n" +
                "Yellow 네가 내게 문득 찾아 왔을 때\n" +
                "어느샌가 내 마음속 가득히\n" +
                "봄을 닮은 온기들이 채워졌어\n" +
                "꽤 자연스레\n" +
                "한 겹 두 겹 칠해져 가네 물감처럼\n" +
                "여기저기 새겨져 가네 문신처럼\n" +
                "네가 스친 자리마다 다른 색의\n" +
                "기억이 덧칠되고 있는걸\n" +
                "차츰차츰 짙어져 가네 까만 밤처럼\n" +
                "계속 나를 칠해줘\n" +
                "더 많은 추억들로\n" +
                "어서 나를 칠해줘\n" +
                "너만의 향기들로\n" +
                "지울 수 없게 해줘\n" +
                "너 아닌 누구도 내 맘속에\n" +
                "그려지지 못하도록\n" +
                "Red 날 뜨겁게 안던 그 순간\n" +
                "화산처럼 터져버렸던 my heart\n" +
                "붉은 자욱이 남았어\n" +
                "내 맘에 아직 따뜻해\n" +
                "Blue 너 때문에 처음 울었던 날도\n" +
                "깊일 알 수 없는 바다 속처럼\n" +
                "아주 파랗게 그려져 버렸는걸\n" +
                "Do you remember\n" +
                "한 겹 두 겹 칠해져 가네 물감처럼\n" +
                "여기저기 새겨져 가네 문신처럼\n" +
                "네가 스친 자리마다\n" +
                "다른 색의 기억이 덧칠되고 있는걸\n" +
                "차츰차츰 짙어져 가네\n" +
                "까만 밤처럼\n" +
                "계속 나를 칠해줘\n" +
                "더 많은 추억들로\n" +
                "어서 나를 칠해줘\n" +
                "너만의 향기들로\n" +
                "지울 수 없게 해줘\n" +
                "너 아닌 누구도 내 맘속에\n" +
                "그려지지 못하도록\n" +
                "까맣게 더 까맣게 변해버려도 괜찮아\n" +
                "우리만의 memories\n" +
                "자꾸자꾸 진해져 가네 espresso처럼\n" +
                "그래 또 덧칠해줘\n" +
                "널 멈추지 말아줘\n" +
                "네가 없인 난 의미 없어\n" +
                "가득가득 채워줘\n" +
                "빈자리는 없게 해줘\n" +
                "너만이 내 유일한 화가");
    }

    public void list8(){
        listener = new YouTubePlayer.OnInitializedListener(){
            //초기화 성공시
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo("afxLaQiLu-o");//url의 맨 뒷부분 ID값만 넣으면 됨
            }
            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
            }
        };
        youTubeView.initialize("AIzaSyBLovcPCxpM1MDswgO7gtwRceVD2vy7odA", listener);
        textView7.setText("비도 오고 그래서 \n" +
                "네 생각이 났어 \n" +
                "생각이 나서 그래서 \n" +
                "그랬던거지 \n" +
                "별 의미 없지 \n" +
                "오늘은 오랜만에 \n" +
                "네 생각을 하는 날이야 \n" +
                "일부러 난 너와 내가 \n" +
                "담겨 있는 노랠 찾아 \n" +
                "오늘은 슬프거나 \n" +
                "우울해도 괜찮은 맘이야 \n" +
                "어차피 이 밤이\n" +
                "다 지나가면은 별 수도 없이\n" +
                "난 또 한 동안은 널 잊고 살테니까\n" +
                "내 가슴 속에만\n" +
                "품고 살아갈테니까\n" +
                "비도 오고 그래서\n" +
                "네 생각이 났어\n" +
                "생각이 나서 그래서\n" +
                "그랬던거지\n" +
                "별 의미 없지\n" +
                "우산 속에 숨어서\n" +
                "네 집을 지나쳐\n" +
                "그 날의 감정을\n" +
                "다시 느껴보고파서\n" +
                "떨어지는 빗물과\n" +
                "시계 초침 소리가\n" +
                "방 안 가득 채우면\n" +
                "그 때로 난 돌아가\n" +
                "차라리 난 이 비가\n" +
                "그치지 않았음 해\n" +
                "매일 기억 속에 살 수 있게\n" +
                "나 널 아프게 했던\n" +
                "못난 놈이니까\n" +
                "널 다시 품에 안을\n" +
                "자격도 없으니까\n" +
                "비도 오고 그래서\n" +
                "네 생각이 났어\n" +
                "생각이 나서 그래서\n" +
                "그랬던거지\n" +
                "별 의미 없지\n" +
                "우산 속에 숨어서\n" +
                "네 집을 지나쳐\n" +
                "그 날의 감정을\n" +
                "다시 느껴보고파서\n" +
                "우리에게 주어진 행복을\n" +
                "너무 빨리 쓴 것 같아\n" +
                "거기까지 인 것 같아\n" +
                "이 비가 그칠 땐 각자 있던 곳에서\n" +
                "다시 살아가야만 해\n" +
                "비도 오고 그래서\n" +
                "네 생각이 났어\n" +
                "생각이 나서 그래서\n" +
                "그랬던거지\n" +
                "별 의미 없지\n" +
                "우산 속에 숨어서\n" +
                "네 집을 지나쳐\n" +
                "그 날의 감정을\n" +
                "다시 느껴보고파서");
    }

    public void list9(){
        listener = new YouTubePlayer.OnInitializedListener(){
            //초기화 성공시
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo("wMkdmElFLUw");//url의 맨 뒷부분 ID값만 넣으면 됨
            }
            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
            }
        };
        youTubeView.initialize("AIzaSyBLovcPCxpM1MDswgO7gtwRceVD2vy7odA", listener);
        textView7.setText("다섯살때부터 나는\n" +
                "피아노를 쳤어 영재였지\n" +
                "베토벤부터 모짜르트\n" +
                "바흐 쇼팽 선배였지\n" +
                "허나 나난 걸 접고서\n" +
                "가사를 썼어 열넷이었지 \n" +
                "난 이게 참 좋아\n" +
                "그건 못 벌어\n" +
                "그 새끼들 모두 엿먹어 \n" +
                "베르사체 무한리필 drank\n" +
                "그게 내 1악장 \n" +
                "Maserati car 하얀색 대리석\n" +
                "house 그게 내 2악장 \n" +
                "Mic는 바로 나의 지휘봉 \n" +
                "불러 maestro maestro \n" +
                "불러 maestro maestro \n" +
                "사실 수트바지보다\n" +
                "내려쳐입는게 훨 더 나\n" +
                "점잖떠는거는 못해\n" +
                "그냥 외쳐버려 돈 쌓자\n" +
                "부자들은 거의\n" +
                "겉으론 젠틀해 \n" +
                "건희씨는 칭호\n" +
                "노창씨는 성을 떼요\n" +
                "방금 나의 라인을 듣고\n" +
                "너는 말해 내가 fucked up\n" +
                "허나 이 삶에 locked up 될바엔\n" +
                "일을 벌릴테야\n" +
                "리스크를 향해 첨벙\n" +
                "비닐 속 안 피아노\n" +
                "꿈꾸던 이는\n" +
                "그걸 치며 살기위해선\n" +
                "돈이 숨구멍임을 \n" +
                "알고서 악보따윈\n" +
                "동네 땅에 큰 구덩이를 \n" +
                "파 묻고 선언했지\n" +
                "내 자신이 classic임임을\n" +
                "딱 박아둬\n" +
                "내게 소나타는 오직 차\n" +
                "그것따윈 never 생각안해\n" +
                "날 비춰라 all of the lights\n" +
                "지금 내 symphony 1악장의\n" +
                "끝이났어 fuck 다 카포\n" +
                "절대로 없어 난 돌아갈일\n" +
                "박수 no no 2악장 play 할렐루야\n" +
                "다섯살때부터 나는\n" +
                "피아노를 쳤어 영재였지\n" +
                "베토벤부터 모짜르트\n" +
                "바흐 쇼팽 선배였지\n" +
                "허나 나난 걸 접고서\n" +
                "가사를 썼어 열넷이었지 \n" +
                "난 이게 참 좋아\n" +
                "그건 못 벌어\n" +
                "그 새끼들 모두 엿먹어 \n" +
                "베르사체 무한리필 drank\n" +
                "그게 내 1악장 \n" +
                "Maserati car 하얀색 대리석\n" +
                "house 그게 내 2악장 \n" +
                "Mic는 바로 나의 지휘봉 \n" +
                "불러 maestro maestro \n" +
                "불러 maestro maestro \n" +
                "Hash hash hash hash\n" +
                "#돈벌어\n" +
                "Hash hash hash hash\n" +
                "#좀처럼 나오지 않는 영재\n" +
                "Shout out to kubrick shout out to\n" +
                "파우스트 괴테 \n" +
                "shout out to michael tyson\n" +
                "shout out to 고흐 warhol\n" +
                "casso 그리고 내 이름을 박길\n" +
                "Woah 한국 아인슈타인\n" +
                "노멀한 애들이 엿먹여\n" +
                "하지만 i dont give a fuck\n" +
                "son imma fuck you up\n" +
                "여기가 무덤이라 적긴 일러 \n" +
                "내 예술의 전당은 club야\n" +
                "불러 날 마에스트로\n" +
                "그럼 난 그렇게 불려\n" +
                "내 계급으론\n" +
                "백건우 카라얀 work위한\n" +
                "정도를 걸을수 없으니 \n" +
                "Deepflow꺼 섞어 잘 어울려 \n" +
                "내가 쳐먹었네 2nd round\n" +
                "클래식 용어론 끝 2악장\n" +
                "내 이런 이력 좋데 내 여잔\n" +
                "Piano와 랩을 함\n" +
                "난 있어 전용 orchestra\n" +
                "키보드 고장난 맥북과\n" +
                "내겐 위인 아닌 갓 세종과 \n" +
                "연주해 내 삶\n" +
                "다섯살때부터 나는\n" +
                "피아노를 쳤어 영재였지\n" +
                "베토벤부터 모짜르트\n" +
                "바흐 쇼팽 선배였지\n" +
                "허나 나난 걸 접고서\n" +
                "가사를 썼어 열넷이었지 \n" +
                "난 이게 참 좋아\n" +
                "그건 못 벌어\n" +
                "그 새끼들 모두 엿먹어\n" +
                "베르사체 무한리필 drank\n" +
                "그게 내 1악장 \n" +
                "Maserati car 하얀색 대리석\n" +
                "house 그게 내 2악장 \n" +
                "Mic는 바로 나의 지휘봉 \n" +
                "불러 maestro maestro\n" +
                "불러 maestro maestro");
    }

    public void list10(){
        listener = new YouTubePlayer.OnInitializedListener(){
            //초기화 성공시
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo("czftJ7E7wa4");//url의 맨 뒷부분 ID값만 넣으면 됨
            }
            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
            }
        };
        youTubeView.initialize("AIzaSyBLovcPCxpM1MDswgO7gtwRceVD2vy7odA", listener);
        textView7.setText("blue\n" +
                "MARTINI BLUE\n" +
                "너란 파도 속에 헤엄치고 있잖아\n" +
                "mmm baby you’re my\n" +
                "blue\n" +
                "MARTINI BLUE\n" +
                "너란 바닷속에 헤어 나오지 못하게\n" +
                "더 감싸 안아줘\n" +
                "my baby\n" +
                "my lady\n" +
                "my baby\n" +
                "my lady\n" +
                "yeah you’re my\n" +
                "blue\n" +
                "MARTINI BLUE\n" +
                "you got me moving on\n" +
                "that martini blue yeah\n" +
                "everything you do yeah\n" +
                "눈빛만 보면 알아 girl\n" +
                "you wanna MMMM\n" +
                "그럼 나는 고갤 끄떡거려\n" +
                "cause you MMMM\n" +
                "girl whats your flavor\n" +
                "flavour MMMM\n" +
                "전화기는 꺼놔\n" +
                "I don’t want that BRRRR\n" +
                "20/20 focused on you baby\n" +
                "바닐라 아이스크림 그 위 체리\n" +
                "파스텔 색 lake\n" +
                "그 위 ferry\n" +
                "파란 ocean 그 위 도시 베니스\n" +
                "내가 블루 네가 베리\n" +
                "그게 우리 둘의 케미\n" +
                "yeah yeah\n" +
                "faisons l’amour paris\n" +
                "yeah yeah yeah\n" +
                "so in love with\n" +
                "the way you move\n" +
                "I’m so into you\n" +
                "into you\n" +
                "you got me\n" +
                "I got you\n" +
                "our love’s deep\n" +
                "like the blue\n" +
                "into you\n" +
                "into you\n" +
                "you got me\n" +
                "I got you\n" +
                "you’re my martini\n" +
                "blue\n" +
                "MARTINI BLUE\n" +
                "너란 파도 속에 헤엄치고 있잖아\n" +
                "mmm baby you’re my\n" +
                "blue\n" +
                "MARTINI BLUE\n" +
                "너란 바닷속에 헤어 나오지 못하게\n" +
                "더 감싸 안아줘\n" +
                "my baby\n" +
                "my lady\n" +
                "my baby\n" +
                "my lady\n" +
                "yeah you’re my\n" +
                "blue\n" +
                "MARTINI BLUE\n" +
                "you got me moving on\n" +
                "that martini blue yeah\n" +
                "everything you do yeah\n" +
                "눈빛 만 보면 알지 girl\n" +
                "I wanna MMMM\n" +
                "그럼 넌 머리를 쓸어 넘겨\n" +
                "cause I’m MMMM\n" +
                "girl guess my flavor\n" +
                "flavour MMMM\n" +
                "전화기는 이미 껐어\n" +
                "you don’t want that BRRRR\n" +
                "허나 내가 원하는 건\n" +
                "지금 그것뿐만은 아니야\n" +
                "너가 힘들어할 때면\n" +
                "꽉 안고 싶단 말이야\n" +
                "깊고 험한 바닷속에 사는\n" +
                "your my Ariel\n" +
                "yeah wait\n" +
                "need you close\n" +
                "yeah hear my note\n" +
                "I’ve been really looking\n" +
                "forward to this like oh\n" +
                "COMING TO YOU LIVE\n" +
                "girl you got me like oh\n" +
                "아름다움에 깊이 빠져있어\n" +
                "like oh like oh oh\n" +
                "가라앉고 있는 나를 와서 구해줘\n" +
                "you’re my martini blue\n" +
                "blue\n" +
                "MARTINI BLUE\n" +
                "너란 파도 속에 헤엄치고 있잖아\n" +
                "mmm baby you’re my\n" +
                "blue\n" +
                "MARTINI BLUE\n" +
                "너란 바닷속에 헤어 나오지 못하게\n" +
                "더 감싸 안아줘\n" +
                "my baby\n" +
                "my lady\n" +
                "my baby\n" +
                "my lady\n" +
                "yeah you’re my\n" +
                "blue\n" +
                "MARTINI BLUE\n" +
                "you got me moving on\n" +
                "that martini blue yeah\n" +
                "everything you do yeah");
    }

    public void list11(){
        listener = new YouTubePlayer.OnInitializedListener(){
            //초기화 성공시
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo("zdKTgwffmdo");//url의 맨 뒷부분 ID값만 넣으면 됨
            }
            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
            }
        };
        youTubeView.initialize("AIzaSyBLovcPCxpM1MDswgO7gtwRceVD2vy7odA", listener);
        textView7.setText("새로운 만남은 싫어 왠지 몰라도\n" +
                "여전히 네가 많이 미워 아직도\n" +
                "운명 같던 만남이\n" +
                "이젠 님에서 남이\n" +
                "되어 떠나갔어 아직도\n" +
                "맴도는 너의 향기\n" +
                "We used to be all turnt up\n" +
                "우린 멀어졌어 점점\n" +
                "넌 아니라 했지만 두고 봐\n" +
                "사랑의 역전\n" +
                "오늘도 외쳐\n" +
                "그전처럼 let's go\n" +
                "앞으로 rewind\n" +
                "처음으로 X O\n" +
                "아직도 널 잊지 못하고 있는\n" +
                "내 모습이 나 싫은데\n" +
                "잊으려 잊으려 해도 그게 안돼 \n" +
                "everyday\n" +
                "너 아니면 안 된다고\n" +
                "끝이란 있을 수 없다고\n" +
                "It ain't over til it's over\n" +
                "It ain't over til it's over\n" +
                "It ain't over til it's over\n" +
                "너의 사랑이 날 망쳐도\n" +
                "날 아프게 한대도\n" +
                "내겐 오직 너 하나뿐\n" +
                "내 사랑은 너로 시작해 너로 끝나\n" +
                "이 자리에 Waiting for you\n" +
                "너 아님 안돼 No\n" +
                "My one and only oh oh oh\n" +
                "너 아님 안돼 No\n" +
                "내 곁엔 너 아니면 안돼 난\n" +
                "다시 날 가둬 너라는 감옥에\n" +
                "너 없는 현실이 가혹해\n" +
                "죽을 만큼 힘들어도 I don't care\n" +
                "난 여우니까 목숨이 아홉 개\n" +
                "수백 번 날 부숴도 매섭게 \n" +
                "몰아치는 너란 파도\n" +
                "I'm Okay 아파도 사랑 앞에 난 \n" +
                "desperado\n" +
                "누가 뭐라 하던 간에\n" +
                "난 아무도 상관 안 해\n" +
                "우리 같이 춤추던 그 노래는 아직 \n" +
                "안 끝났기에\n" +
                "널 향해 지금 외쳐\n" +
                "그전처럼 let's go\n" +
                "앞으로 rewind\n" +
                "처음으로 X O\n" +
                "마지막이라고 차갑게 말하던 네 \n" +
                "모습이 싫은데\n" +
                "지우려 지우려 해도\n" +
                "자꾸 난 널 그리네\n" +
                "너 아니면 안 된다고\n" +
                "끝이란 있을 수 없다고\n" +
                "It ain't over til it's over\n" +
                "It ain't over til it's over\n" +
                "It ain't over til it's over\n" +
                "너의 사랑이 날 망쳐도\n" +
                "날 아프게 한대도\n" +
                "내겐 오직 너 하나뿐\n" +
                "내 사랑은 너로 시작해 너로 끝나\n" +
                "이 자리에 Waiting for you\n" +
                "너 아님 안돼 No\n" +
                "My one and only oh oh oh\n" +
                "너 아님 안돼 No\n" +
                "내 곁엔 너 아니면 안돼 난\n" +
                "눈을 감아도 생각나\n" +
                "니 얼굴 표정 하나하나\n" +
                "넌 나의 첨이자 마지막 사랑이야 \n" +
                "don't say good bye\n" +
                "너의 사랑이 날 망쳐도\n" +
                "날 아프게 한대도\n" +
                "내겐 오직 너 하나뿐\n" +
                "내 사랑은 너로 시작해 너로 끝나\n" +
                "이 자리에 Waiting for you\n" +
                "너 아님 안돼 No\n" +
                "My one and only oh oh oh\n" +
                "너 아님 안돼 No\n" +
                "내 곁엔 너 아니면 안돼 난");
    }

    public void list12(){
        listener = new YouTubePlayer.OnInitializedListener(){
            //초기화 성공시
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo("gnLwCb8Cz7I");//url의 맨 뒷부분 ID값만 넣으면 됨
            }
            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
            }
        };
        youTubeView.initialize("AIzaSyBLovcPCxpM1MDswgO7gtwRceVD2vy7odA", listener);
        textView7.setText("그리울 때 눈 감으면 \n" +
                "더 잘 보이는 그런 사람 \n" +
                "잊으려 하고 지우려 하면 \n" +
                "더 많이 생각나는 사람 \n" +
                "그 사람 꼭 올 거라고 \n" +
                "내 가슴에 해로운 거짓말을 하고 \n" +
                "꼭 올 거라는 말은 안 했지만 \n" +
                "기다릴 수 밖에 없는 사람 \n" +
                "너무나 많이 사랑한 죄 \n" +
                "널 너무나 많이 사랑한 죄 \n" +
                "난 너로 인해 그 죄로 인해 \n" +
                "기다림을 앓고 있다고 \n" +
                "내가 더 많이 사랑한 죄 \n" +
                "널 너무나 많이 그리워한 죄 \n" +
                "난 너로 인해 그 죄로 인해 \n" +
                "눈물로 앓고 있다고 이렇게 \n" +
                "그 사람 꼭 올 거라고 \n" +
                "내 가슴에 해로운 거짓말을 하고 \n" +
                "꼭 올 거라는 말은 안 했지만 \n" +
                "기다릴 수 밖에 없는 사람 \n" +
                "너무나 많이 사랑한 죄 \n" +
                "널 너무나 많이 사랑한 죄 \n" +
                "난 너로 인해 그 죄로 인해 \n" +
                "기다림을 앓고 있다고 \n" +
                "내가 더 많이 사랑한 죄 \n" +
                "널 너무나 많이 그리워한 죄 \n" +
                "난 너로 인해 그 죄로 인해 \n" +
                "눈물로 앓고 있다고 \n" +
                "헤어짐은 늘 빠른 사람 \n" +
                "잊혀짐은 늘 더딘 사람 \n" +
                "늘 나에게만 늘 모진 사람 \n" +
                "나 혼자 앓고 있었다고 \n" +
                "그대 나를 이렇게 멀리 \n" +
                "떠나가야만 했니 \n" +
                "그대 나를 이렇게 멀리 \n" +
                "떠나가야만 했니 \n" +
                "그저 내 목숨 다 바쳐 사랑할 사람 \n" +
                "이제 날 잊고 살아갈 무정한 사람 \n" +
                "그저 내 전부를 다 바쳐 \n" +
                "사랑할 사람 \n" +
                "이제 날 잊고 살아갈 너 \n" +
                "내 목숨 다 바쳐서 사랑할 사람 \n" +
                "내게는 눈물만 주고 간 사람 \n" +
                "늘 나에게만 늘 모진 사람 \n" +
                "나 혼자 앓고 있었다고 \n" +
                "내가 더 많이 사랑한 죄 \n" +
                "널 너무나 많이 그리워한 죄 \n" +
                "난 너로 인해 그 죄로 인해 \n" +
                "눈물로 앓고 있다고 이렇게 ");
    }

    public void list13(){
        listener = new YouTubePlayer.OnInitializedListener(){
            //초기화 성공시
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo("kqckfuUnC1U");//url의 맨 뒷부분 ID값만 넣으면 됨
            }
            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
            }
        };
        youTubeView.initialize("AIzaSyBLovcPCxpM1MDswgO7gtwRceVD2vy7odA", listener);
        textView7.setText("Girl 말해줘 네 마음 바로 지금\n" +
                "Baby 같이 올라가자 하늘 위로\n" +
                "All I wanna do is kick it with you\n" +
                "너의 몸매 그린 것만 같아 미술\n" +
                "오늘 의상처럼 네 마음도 씨쓰루\n" +
                "All I wanna do is kick it with you\n" +
                "Girl 뭐가 중요한지\n" +
                "baby 바로 말해줄게\n" +
                "나 지금 5천만원짜리 시계 찼지만\n" +
                "나는 너를 훨씬 아끼지 babe\n" +
                "네가 원한다면 안 찰게\n" +
                "허세 따위는 안 통하니까\n" +
                "넌 정말 신기한 여자\n" +
                "나를 노력하게 만드니까\n" +
                "baby oh yeah\n" +
                "우리 둘의 밤을 상상했어\n" +
                "girl all night\n" +
                "몸에 타투를 보여줘\n" +
                "If it's alright\n" +
                "Girl 말해줘 네 마음 바로 지금\n" +
                "Baby 같이 올라가자 하늘 위로\n" +
                "All I wanna do is kick it with you\n" +
                "너의 몸매 그린 것만 같아 미술\n" +
                "오늘 의상처럼 네 마음도 씨쓰루\n" +
                "All I wanna do is kick it with you\n" +
                "어떡해 내 맘에 네가 들어오려 해\n" +
                "쉽게 빠질까 봐 위험해 보여\n" +
                "조심하려 할 때\n" +
                "움직여지지 않아\n" +
                "날 보는 네 시선이 내 몸을 감아\n" +
                "하나로 얽혀 너와 나\n" +
                "이제부턴 아무도 풀지 못해\n" +
                "뻔하지 않게 우연같이 만나 baby\n" +
                "서로에게 녹아들어\n" +
                "오늘밤 우리 기분은 저 하늘 구름 위\n" +
                "네 몸에 타투를 보여줘\n" +
                "이미 내 맘은 준비되어있어\n" +
                "Boy 말할게 내 마음 바로 지금\n" +
                "그래 같이 올라가자 하늘 위로\n" +
                "All I wanna do is kick it with you\n" +
                "네가 원한대로 내 대답은 Me too\n" +
                "이제부터 널 부르게 해줘 My boo\n" +
                "All I wanna do is kick it with you\n" +
                "내가 하고 싶은 모든 것 뒤엔\n" +
                "너와 함께 가 생략 되어 있지\n" +
                "요즘 인기 많은\n" +
                "교포오빠들과는 달라\n" +
                "김치 향기가 배어있지\n" +
                "덕분에 난 몰아 호랑이\n" +
                "택 달린 옷은 방에 쌓여가고 있어\n" +
                "밤에 입어 편하게\n" +
                "이젠 너는 나 나는 너로 구분 짓고\n" +
                "ALL I WANNA DO 라고 말해 편하게\n" +
                "너의 옆자리를 상상할 거고\n" +
                "그곳에는 내가 있게 될 거야\n" +
                "그리고 너에 대해 장담하건대\n" +
                "뭐든 할 수 있을 거라고 믿게 될 거야\n" +
                "Girl 말해줘 네 마음 바로 지금\n" +
                "Baby 같이 올라가자 하늘 위로\n" +
                "All I wanna do is kick it with you\n" +
                "너의 몸매 그린 것만 같아 미술\n" +
                "오늘 의상처럼 네 마음도 씨쓰루\n" +
                "All I wanna do is kick it with you");
    }

    public void list14(){
        listener = new YouTubePlayer.OnInitializedListener(){
            //초기화 성공시
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo("eelfrHtmk68");//url의 맨 뒷부분 ID값만 넣으면 됨
            }
            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
            }
        };
        youTubeView.initialize("AIzaSyBLovcPCxpM1MDswgO7gtwRceVD2vy7odA", listener);
        textView7.setText("Love love the stars\n" +
                "Love love the moon\n" +
                "별 다를 것 없이\n" +
                "똑같은 공기\n" +
                "똑같은 침대에서\n" +
                "보이는 천장까지\n" +
                "왜 별 이유 없이\n" +
                "공허한 건지\n" +
                "그저 몇 시간 째\n" +
                "멍만 때리는 게\n" +
                "처음에는\n" +
                "배가 고픈가 했었는데\n" +
                "No way no way no way\n" +
                "요새는\n" +
                "칸예 새 앨범을 들어도\n" +
                "뻔해 뻔해 뻔해\n" +
                "TV를 틀어 놓은 채\n" +
                "채널만 돌려 보네\n" +
                "But bae 별 의미 없네\n" +
                "다 너의 반 반\n" +
                "반의 반의 반도\n" +
                "채워주질 못 하네\n" +
                "채워지지가 않네 Yeah\n" +
                "딱 너의 반 반\n" +
                "반의 반이라도\n" +
                "내게 남았더라면\n" +
                "이렇게 붕 떠있지는\n" +
                "않을 텐데\n" +
                "너 없는 밤도\n" +
                "달은 떴다는데\n" +
                "보이지 않아\n" +
                "네 생각에 가려진 채 Yeah\n" +
                "마음이 기운 채로\n" +
                "판단이 설 리가\n" +
                "너 하나 없다고\n" +
                "내가 이럴 리가 없는데\n" +
                "자꾸 그 때로 또 되감기 돼\n" +
                "네가 있던 자리\n" +
                "그 자리 위 밤하늘까지 보여\n" +
                "저 반 쪽 짜리 달이\n" +
                "딱 지금 나의 모습 같지\n" +
                "다 너의 반 반\n" +
                "반의 반의 반도\n" +
                "채워주질 못 하네\n" +
                "채워지지가 않네 Yeah\n" +
                "딱 너의 반 반\n" +
                "반의 반이라도\n" +
                "내게 남았더라면\n" +
                "이렇게 붕 떠있진 않을 텐데\n" +
                "내일의 어둠이\n" +
                "저 달을 한 입 삼키면\n" +
                "둘이 만들었던\n" +
                "세계도 더 작아질 텐데\n" +
                "그리움만 꽉 차겠지\n" +
                "지루한 하루들을 보낸 후\n" +
                "보름달 하늘에 뜰 때쯤에는\n" +
                "우린 하나라고\n" +
                "떠들고 다닐 때만 해도\n" +
                "너는 너고 나는 나라는 게\n" +
                "이렇게도 명확해질지 몰랐어\n" +
                "서로 생각할 시간\n" +
                "시간 초과된 기분\n" +
                "더 지나면 서로\n" +
                "돌아오라고도 못 해\n" +
                "난 지금 돈키호테처럼\n" +
                "정처 없이 네 사랑을 꿈꾸네\n" +
                "난 네 눈만 봐도\n" +
                "텅 빈 이 맘을 다 채울 텐데\n" +
                "다 너의 반 반\n" +
                "반의 반의 반도\n" +
                "채워주질 못 하네\n" +
                "채워지지가 않네 Yeah\n" +
                "딱 너의 반 반\n" +
                "반의 반이라도\n" +
                "내게 남았더라면\n" +
                "이렇게 붕 떠있진 않을 텐데\n" +
                "Love love the stars\n" +
                "Love love the moon\n" +
                "딱 너의 반 반\n" +
                "반의 반이라도\n" +
                "내게 남았더라면\n" +
                "그랬더라면");
    }

    public void list15(){
        listener = new YouTubePlayer.OnInitializedListener(){
            //초기화 성공시
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo("mzA5qaCs7XE");//url의 맨 뒷부분 ID값만 넣으면 됨
            }
            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
            }
        };
        youTubeView.initialize("AIzaSyBLovcPCxpM1MDswgO7gtwRceVD2vy7odA", listener);
        textView7.setText("이제 익숙해지는 것 같아\n" +
                "키가 작을 때부터 해왔던 상상\n" +
                "마음껏 펼치고는 꿀 같은 단잠\n" +
                "자고 일어났어 어딜 가든 \n" +
                "나는 항상\n" +
                "자신감 넘치게 행동해야 하지\n" +
                "아직 많이 부족하긴 해도 끝까지\n" +
                "이뤄낼 거야 내 꿈 너도 알지\n" +
                "그래도 네가 있어 난 힘이 나지\n" +
                "너의 하루는 어땠어\n" +
                "느껴져 딱 목소리에서\n" +
                "누가 또 네 심기에 손 댔어\n" +
                "맞아 전부 그 사람이 잘못했어\n" +
                "쓰다듬어주고 싶어 네 머리를\n" +
                "오늘도 고생 많이 했어\n" +
                "이번 주말에는 떠나자 어디든\n" +
                "일단 눈 감아 내 팔에 기대서\n" +
                "Baby 난 너만 담아\n" +
                "오늘은 편하게 내게 안겨도 돼\n" +
                "겁먹지마\n" +
                "이 밤이 우릴 환하게 반겨주네\n" +
                "눈을 감아\n" +
                "두 눈을 감아\n" +
                "허리에 팔을 감아\n" +
                "나만 믿고 따라와\n" +
                "쉬는 동안에도 주말마다 일이 \n" +
                "생기지\n" +
                "가끔은 너무 정신 없어서 내 몸도 \n" +
                "못 챙기지\n" +
                "내 나름대로의 욕심 때문에 압박이 \n" +
                "머리를 조여도\n" +
                "다 풀어냈을 때 그 시원함이 나를 \n" +
                "무대위로 또 올려줘\n" +
                "나도 오늘 일을 끝냈으니 편안하게 \n" +
                "와서 안겨도 돼\n" +
                "현실이 꼬리를 물기 전에 더 이상은 \n" +
                "아무것도 생각하지 않기로 해\n" +
                "괜찮아 괜찮아 우리 둘 밖에 없어\n" +
                "네가 하고 싶은 대로 해 준비 \n" +
                "안된 건 없어\n" +
                "Baby 난 너만 담아\n" +
                "오늘은 편하게 내게 안겨도 돼\n" +
                "겁먹지마\n" +
                "이 밤이 우릴 환하게 반겨주네\n" +
                "눈을 감아\n" +
                "두 눈을 감아\n" +
                "허리에 팔을 감아\n" +
                "나만 믿고 따라와\n" +
                "미리 맞춰놨어 적당한 온도\n" +
                "너 때문에 오늘 아침부터 뎁혀 놔서 \n" +
                "따듯해 내 몸도\n" +
                "이리 와서 누워도 돼 내 옆에 눈감고 \n" +
                "기대봐 내 옆에\n" +
                "잡은 손 놓지 않아 절대 네가 눈을 떠도 \n" +
                "어디 가지 않아 절대\n" +
                "걱정하지 마 우리가 만날 시간은 많아\n" +
                "오늘 따라 밤이 차갑지만 곁에 있어 \n" +
                "괜찮아\n" +
                "편하게 눈감아 내 곁에 누워도 돼\n" +
                "두 손을 꼭 잡고 Ma Baby\n" +
                "Baby 난 너만 담아\n" +
                "오늘은 편하게 내게 안겨도 돼\n" +
                "겁먹지마\n" +
                "이 밤이 우릴 환하게 반겨주네\n" +
                "눈을 감아\n" +
                "두 눈을 감아\n" +
                "허리에 팔을 감아\n" +
                "나만 믿고 따라와\n" +
                "내 노래의 모든 주제가\n" +
                "니 이야기가 아니지만\n" +
                "니가 있었기 때문에\n" +
                "가능한 둘의 이야기야\n" +
                "나 때문에 너의 하루가\n" +
                "더 즐거웠으면 좋겠어\n" +
                "난 하지 않아 절대 말로만\n" +
                "거짓은 하나도 안 보탰어");
    }

    public void list16(){
        listener = new YouTubePlayer.OnInitializedListener(){
            //초기화 성공시
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo("YowZgL1AOTA");//url의 맨 뒷부분 ID값만 넣으면 됨
            }
            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
            }
        };
        youTubeView.initialize("AIzaSyBLovcPCxpM1MDswgO7gtwRceVD2vy7odA", listener);
        textView7.setText("One two three four\n" +
                "back to the one two\n" +
                "One two three back to yeah\n" +
                "One two three four\n" +
                "back to the one two\n" +
                "One two three back to yeah\n" +
                "난 널 보고 있지\n" +
                "거울을 통해서\n" +
                "머리를 만지는 척 해 \n" +
                "자신 있게 걸어가\n" +
                "말을 걸고 싶은데 \n" +
                "아직까진 널 두고 볼게 \n" +
                "내 눈짓에 빠져 들겠어 \n" +
                "누가 된다 해도 \n" +
                "나를 밀어내진 못하는 걸 \n" +
                "네 가슴에 향수처럼 \n" +
                "늘 뿌려놓게 해줘\n" +
                "네가 나를 맡을 수 있게 \n" +
                "One two three four\n" +
                "back to the one two\n" +
                "One two three back to yeah\n" +
                "One two three four\n" +
                "back to the one two\n" +
                "One two three back to yeah\n" +
                "If I take you out to shop you go wow \n" +
                "If I take you places that u wanna go \n" +
                "Hit me from the back Don't stop now\n" +
                "Let's go Hit it Hit it\n" +
                "Bust it one more\n" +
                "한잔의 Wine과 Steak\n" +
                "너와 First date\n" +
                "Gentleman I won't make mistake \n" +
                "실수라는 것은\n" +
                "Chance I won't take \n" +
                "니 맘을 뺏는 것은 내게는 \n" +
                "Piece of a cake \n" +
                "넌 날 보고 있지\n" +
                "거울을 통해서\n" +
                "화장을 고치는 척 해 \n" +
                "곁에 그 남자로는\n" +
                "너를 채울 수가 없어 \n" +
                "난 너를 위해 준비된 남자인데\n" +
                "내 눈짓에 빠져 들겠어 \n" +
                "누가 된다 해도 \n" +
                "나를 밀어내진 못하는 걸 \n" +
                "네 가슴에 향수처럼 \n" +
                "늘 뿌려놓게 해줘\n" +
                "네가 나를 맡을 수 있게 \n" +
                "천천히 와도 돼 난 All day wait \n" +
                "여기서 난 All day \n" +
                "기다릴 수 있어 너만 오면 돼\n" +
                "나 시간은 많아 But 참지는 않아 \n" +
                "Just one never let you go\n" +
                "끌려 오겠지 발걸음은 내게로 \n" +
                "지금부터 셋까지 셀게 \n" +
                "One two three One more time\n" +
                "다시 음악이 바뀔 때쯤 내게로 \n" +
                "You are my girl\n" +
                "You are my girl It's alright\n" +
                "내 손짓에 다가오겠어 누구에게라도\n" +
                "빼앗기지 않게 나를 봐줘 \n" +
                "네 손목에 시계처럼\n" +
                "늘 찰 수 있게 해줘 \n" +
                "시간마다 날 볼 수 있게 \n" +
                "순간이겠지 너의 맘이 내게로 \n" +
                "지금부터 셋까지 셀게 \n" +
                "One two three\n" +
                "Two more times\n" +
                "네가 문 밖을 나설 때쯤 내게로 \n" +
                "Come back girl \n" +
                "Come back girl It's alright\n" +
                "Come back girl\n" +
                "One more time");
    }

    public void list17(){
        listener = new YouTubePlayer.OnInitializedListener(){
            //초기화 성공시
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo("aiHSVQy9xN8");//url의 맨 뒷부분 ID값만 넣으면 됨
            }
            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
            }
        };
        youTubeView.initialize("AIzaSyBLovcPCxpM1MDswgO7gtwRceVD2vy7odA", listener);
        textView7.setText("Ba-banana Ba-ba-banana-nana\n" +
                "Ba-banana Ba-ba-banana-nana\n" +
                "Ba-banana Ba-ba-banana-nana\n" +
                "Ba-banana Ba-ba-banana-nana\n" +
                "Oh 아무것도 안 했는데\n" +
                "왜 시간은 벌써 3시\n" +
                "아이스 아메리카노 마셔도 왜\n" +
                "더 후끈후끈하니\n" +
                "태양은 우릴 놀리고\n" +
                "아스팔트 온도 50도 Wow\n" +
                "원해요 에너지\n" +
                "차갑거나 아예 뜨겁게\n" +
                "Summer Magic\n" +
                "반짝인 그 Ocean 위로\n" +
                "난 벌써 날아\n" +
                "Go Go 에어플레인\n" +
                "번개처럼 날아라\n" +
                "카우아이 파도 속 나를 던져 버리게\n" +
                "이예이예 이예이예이예이예\n" +
                "Let’s power up\n" +
                "까맣게 다 타버릴 거예요\n" +
                "Ba-banana Ba-ba-banana-nana\n" +
                "Ba-banana Ba-ba-banana-nana\n" +
                "Ba-banana Ba-ba-banana-nana Ba\n" +
                "Let’s power up\n" +
                "놀 때 제일 신나니까요\n" +
                "Oh 좋아하는 걸 원해봐요\n" +
                "I want it I want it\n" +
                "want it want it yeah\n" +
                "매일 그대 열정은 타오르죠\n" +
                "I’ll take it I’ll take it\n" +
                "take it take it yeah\n" +
                "그런 게 우리의 천재적인 파워야\n" +
                "즉흥적 본능적 맞아 그게 필요해\n" +
                "떠나요 오늘 밤\n" +
                "짜릿함을 찾으러 레벨업\n" +
                "엔진 소리 들뜬 맘의\n" +
                "백그라운드 뮤직 봐\n" +
                "벌써 날아\n" +
                "Go Go\n" +
                "에어플레인 태양 위로 날아라\n" +
                "Diving to the sky\n" +
                "완전 소름 돋았어\n" +
                "이예이예 이예이예이예이예\n" +
                "Let’s power up\n" +
                "까맣게 다 타버릴 거예요\n" +
                "Go Go 에어플레인\n" +
                "번개처럼 날아라\n" +
                "카우아이 파도 속 나를 던져 버리게\n" +
                "이예이예 이예이예이예이예\n" +
                "Let’s power up\n" +
                "까맣게 다 타버릴 거예요\n" +
                "Ba-banana Ba-ba-banana-nana\n" +
                "Ba-banana Ba-ba-banana-nana\n" +
                "Ba-banana Ba-ba-banana-nana Ba\n" +
                "Let’s power up\n" +
                "놀 때 제일 신나니까요\n" +
                "선생님은 내게 말씀하셨죠\n" +
                "놀 때도 일할 때도 즐겁게 해\n" +
                "그래 난 유달리 반짝거렸죠\n" +
                "뜨거움도 새로움도 It’s mine\n" +
                "Go Go 에어플레인\n" +
                "번개처럼 날아라\n" +
                "카우아이 파도 속 나를 던져 버리게\n" +
                "이예이예 이예이예이예이예\n" +
                "Let’s power up\n" +
                "까맣게 다 타버릴 거예요\n" +
                "Go Go 에어플레인\n" +
                "태양 위로 날아라\n" +
                "Diving to the sky\n" +
                "완전 소름 돋았어\n" +
                "이예이예 이예이예이예이예\n" +
                "Let’s power up\n" +
                "까맣게 다 타버릴 거예요\n" +
                "Ba-banana Ba-ba-banana-nana\n" +
                "Ba-banana Ba-ba-banana-nana\n" +
                "Ba-banana Ba-ba-banana-nana Ba\n" +
                "Let’s power up\n" +
                "놀 때 제일 신나니까요");
    }

    public void list18(){
        listener = new YouTubePlayer.OnInitializedListener(){
            //초기화 성공시
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo("EVaV7AwqBWg");//url의 맨 뒷부분 ID값만 넣으면 됨
            }
            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
            }
        };
        youTubeView.initialize("AIzaSyBLovcPCxpM1MDswgO7gtwRceVD2vy7odA", listener);
        textView7.setText("너와 나의 입술이 점점 \n" +
                "느껴지는 이 순간 속에 뜨거운 공기 \n" +
                "온몸에 전율이 와 \n" +
                "이제 너와 내가 써 내릴 Story \n" +
                "I don't know why \n" +
                "나도 모르게 \n" +
                "더 빠져들어가 \n" +
                "숨 막히게 Baby \n" +
                "I don't know why \n" +
                "지금 이 순간 \n" +
                "멈출 수 없는 기분 No No No No \n" +
                "Make me feel so high \n" +
                "미치겠어 날 멈출 순 없어 \n" +
                "You make me feel so high \n" +
                "I'm so crazy 너가 나를 본 순간 \n" +
                "막 끌려 더 날 당겨줘 Baby \n" +
                "I'm feelin’ so energetic \n" +
                "오늘 밤 둘이 Out of control Yeah \n" +
                "I'm feelin’ so energetic \n" +
                "내 심장이 멈추는 그 순간까지 \n" +
                "너를 지켜줄게 사라지지 않게 \n" +
                "한 순간의 작은 약속들은 아냐 \n" +
                "이젠 말해 내게 Baby \n" +
                "You tell me how to feel \n" +
                "Uh 1 2 3 & 4 \n" +
                "니 옆의 딴 놈들이 거슬려 좀 \n" +
                "Who am I 오직 너만을 지키는 킬러 \n" +
                "말 그대로 난 좀 죽여줘 Yeah \n" +
                "Uh 너를 품에 안고 비상해 \n" +
                "걱정은 버려 지하에 \n" +
                "뭐를 하든 간에 하나라는 수식어가 \n" +
                "맴돌 거야 너와 나의 귓가에 \n" +
                "Make me feel so high \n" +
                "미치겠어 날 멈출 순 없어 \n" +
                "You make me feel so high \n" +
                "I'm so crazy 너가 나를 본 순간 \n" +
                "막 끌려 더 날 당겨줘 Baby \n" +
                "I'm feelin’ so energetic \n" +
                "오늘 밤 둘이 Out of control Yeah \n" +
                "I'm feelin’ so energetic \n" +
                "I'm feelin’ good \n" +
                "I wanna touch \n" +
                "멈출 수 없는 이 기분은 마치 Freedom \n" +
                "I'm feelin’ good \n" +
                "I wanna touch baby \n" +
                "어서 내게 와줘 Tonight Yeah \n" +
                "Alright \n" +
                "Oh Oh Work your body \n" +
                "다가와서 즐길 시간이 Let’s dance \n" +
                "아껴둔 너의 신발이 \n" +
                "더러워지더라도 \n" +
                "움직여 빨리 Hurry up \n" +
                "질문은 나중에 해\n" +
                "딴 남자들은 넘보지 말게\n" +
                "누가 봐도 So 쿨하게\n" +
                "이제 시작해 You know I mean\n" +
                "막 끌려 더 날 당겨줘 Baby\n" +
                "I'm feelin’ so energetic\n" +
                "너와 단둘이 Out of control Yeah\n" +
                "I'm feelin’ so energetic");
    }

    public void list19(){
        listener = new YouTubePlayer.OnInitializedListener(){
            //초기화 성공시
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo("B1xWdZA95Nc");//url의 맨 뒷부분 ID값만 넣으면 됨
            }
            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
            }
        };
        youTubeView.initialize("AIzaSyBLovcPCxpM1MDswgO7gtwRceVD2vy7odA", listener);
        textView7.setText("내 목에 줄 세 개\n" +
                "내가 살아온\n" +
                "그때에 느낀 색깔\n" +
                "두고두고 담아왔던 생각\n" +
                "위로 풀었지 빈틈도 없이 가득\n" +
                "파란 빨간 초록 물감으로\n" +
                "엄마는 남이었지\n" +
                "불러본 적도 없이\n" +
                "편안할 맘이 없어\n" +
                "불편했던 아이였지\n" +
                "그 흔한 조명 없이\n" +
                "밝았던 아이였지\n" +
                "대부분 열이 붙던\n" +
                "내 나인 파랑이었지\n" +
                "내 목에 줄 세 개\n" +
                "내가 살아온\n" +
                "그때에 느낀 색깔\n" +
                "두고두고 담아왔던 생각\n" +
                "위로 풀었지 빈틈도 없이 가득\n" +
                "파란 빨간 초록 물감으로\n" +
                "이별로 취해야지\n" +
                "저 별로 날아가지\n" +
                "하루를 별 일없이\n" +
                "사는 건 바보 같았지\n" +
                "낮에는 노랠 했지\n" +
                "밤에는 주정했지\n" +
                "뜨겁던 스물일곱\n" +
                "여름은 빨강이었지\n" +
                "내 목에 줄 세 개\n" +
                "내가 살아온\n" +
                "그때에 느낀 색깔\n" +
                "두고두고 담아왔던 생각\n" +
                "위로 풀었지 빈틈도 없이 가득\n" +
                "파란 빨간 초록 물감으로\n" +
                "밤을 걷지 그리운 일을 적지\n" +
                "좋아서 걷는 거고\n" +
                "불안해서 적는 거지\n" +
                "사실은 잘 모르지\n" +
                "어떻게 살아갈지\n" +
                "적당한 어른이고\n" +
                "아프면 작아지겠지\n" +
                "감았던 눈을 뜨면\n" +
                "남은 건 초록이겠지\n" +
                "내 목에 줄 세 개\n" +
                "내가 살아온\n" +
                "그때에 느낀 색깔\n" +
                "두고두고 담아왔던 생각\n" +
                "위로 풀었지 빈틈도 없이 가득\n" +
                "파란 빨간 초록 물감으로");
    }

    public void list20(){
        listener = new YouTubePlayer.OnInitializedListener(){
            //초기화 성공시
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo("3q22SInyiX8");//url의 맨 뒷부분 ID값만 넣으면 됨
            }
            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
            }
        };
        youTubeView.initialize("AIzaSyBLovcPCxpM1MDswgO7gtwRceVD2vy7odA", listener);
        textView7.setText("너 아닌 척하지마\n" +
                "눈에 보이지만\n" +
                "넘어가는 걸\n" +
                "What did you do yesterday\n" +
                "곰인 척하지마\n" +
                "여우인 걸 알지만\n" +
                "넘어가는 걸\n" +
                "What did you do yesterday\n" +
                "What did you do yesterday\n" +
                "What did you do do do do\n" +
                "일찍 잔다는 너\n" +
                "요새 피곤하다며\n" +
                "열한 시간 동안\n" +
                "잠수더니 또 피곤하대\n" +
                "무심코 내려놓은 듯한 폰은\n" +
                "오늘도 덮어놓고는\n" +
                "내가 예민하대\n" +
                "어디까지가 진실 어디까지가\n" +
                "거짓인지 어디 설명해봐\n" +
                "넌 얼굴색 하나 안 변하고\n" +
                "육하원칙으로 반론해\n" +
                "언제나 쏘아붙이면\n" +
                "대활 거부해\n" +
                "팩트를 들이대면 모르쇠\n" +
                "Yesterday all my trouble\n" +
                "came close to me\n" +
                "또 나만 호구된 청문회\n" +
                "너 아닌 척하지마\n" +
                "눈에 보이지만\n" +
                "넘어가는 걸\n" +
                "What did you do yesterday\n" +
                "곰인 척하지마\n" +
                "여우인 걸 알지만\n" +
                "넘어가는 걸\n" +
                "What did you do yesterday\n" +
                "넌 너가 예쁜 걸\n" +
                "알아서 문제야\n" +
                "No no no no\n" +
                "은근슬쩍 시선 즐기는 너\n" +
                "불안하게 왜 그래\n" +
                "No no no no\n" +
                "프로필 사진은 왜 바꾼 거야\n" +
                "옷은 왜 어제랑 똑같은 거야\n" +
                "일부러 싫증 유발하는 거야\n" +
                "끝장내고 싶은 거야 뭐야\n" +
                "I Don’t Know\n" +
                "Why I Love You eh\n" +
                "심증뿐인 추궁은\n" +
                "본전도 못 건졌네\n" +
                "넌 내 머리 위 난 네 발 밑\n" +
                "아쉬운 쪽이\n" +
                "손해 보는 싸움\n" +
                "너 아닌 척하지마\n" +
                "눈에 보이지만\n" +
                "넘어가는 걸\n" +
                "What did you do yesterday\n" +
                "곰인 척하지마\n" +
                "여우인 걸 알지만\n" +
                "넘어가는 걸\n" +
                "What did you do yesterday\n" +
                "라리라라라 라라라라라\n" +
                "돌고 도는 패턴이지만\n" +
                "라리라라라 라라라라라\n" +
                "넘어가는 걸\n" +
                "What did you do yesterday\n" +
                "알면서도 속아주는 거야\n" +
                "그만큼 널 좋아하는 거야\n" +
                "다만 들키지만 말아줘\n" +
                "그럼 다 눈감아줄게\n" +
                "뭐든지 해줄게\n" +
                "너 아닌 척하지마\n" +
                "눈에 보이지만\n" +
                "넘어가는 걸\n" +
                "What did you do yesterday\n" +
                "곰인 척하지마\n" +
                "여우인 걸 알지만\n" +
                "넘어가는 걸\n" +
                "What did you do yesterday\n" +
                "라리라라라 라라라라라\n" +
                "돌고 도는 패턴이지만\n" +
                "라리라라라 라라라라라\n" +
                "넘어가는 걸\n" +
                "What did you do yesterday");
    }

    public void defaultt(){
        textView7.setText("미구현된 텍스트");
    }

}
