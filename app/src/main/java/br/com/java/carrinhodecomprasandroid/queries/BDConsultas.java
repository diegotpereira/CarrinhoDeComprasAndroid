package br.com.java.carrinhodecomprasandroid.queries;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.ListenerRegistration;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import br.com.java.carrinhodecomprasandroid.model.CarrinhoItemModelo;
import br.com.java.carrinhodecomprasandroid.model.CategoriaModelo;
import br.com.java.carrinhodecomprasandroid.model.EnderecoModelo;
import br.com.java.carrinhodecomprasandroid.model.HorizontalProdutoScrollModelo;
import br.com.java.carrinhodecomprasandroid.model.ListaComprasModelo;
import br.com.java.carrinhodecomprasandroid.model.MeuPedidoItemModelo;
import br.com.java.carrinhodecomprasandroid.model.NotificacaoModelo;
import br.com.java.carrinhodecomprasandroid.model.PrincipalPaginaModelo;
import br.com.java.carrinhodecomprasandroid.model.SliderModelo;

public class BDConsultas {

    // instancia Firebase
    public static FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();

    public static String email, nome, perfil;

    public static List<CategoriaModelo> categoriaModeloLista = new ArrayList<>();
    public static List<List<PrincipalPaginaModelo>> listas = new ArrayList<>();
    public static List<String> carregarCategoriasNomes = new ArrayList<>();
    public static List<PrincipalPaginaModelo> principalPaginaModeloLista = new ArrayList<>();
    public static List<ListaComprasModelo> listaComprasModeloLista = new ArrayList<>();

    public static List<String> carregarCategoriasNome = new ArrayList<>();
    public static List<String> listaDeCompras = new ArrayList<>();

    // para avaliação usuários
    public static List<String> meuAvaliacaoIds = new ArrayList<>();
    public static List<Long> minhaAvaliacoes = new ArrayList<>();

    public static List<String> carrinhoLista = new ArrayList<>();
    public static List<CarrinhoItemModelo> carrinhoItemModeloList = new ArrayList<>();

    public static int selecionarEndereco = -1;
    public static List<EnderecoModelo> enderecoModeloLista = new ArrayList<>();

    public static List<MeuPedidoItemModelo> meuPedidoItemModeloLista = new ArrayList<>();

    public static List<NotificacaoModelo> notificacaoModeloLista = new ArrayList<>();

    public static ListenerRegistration registration;

    // criamos uma lista falsa, então usamos o recyclerview como parâmetro
    public static void carregarCategorias(final RecyclerView categoriaRecyclerView, final Context context) {
        categoriaModeloLista.clear();

        firebaseFirestore.collection("CATEGORIAS").orderBy("index").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot documentSnapshot : task.getResult()) {
                                categoriaModeloLista.add(new CategoriaModelo(documentSnapshot.get("icon").toString(), documentSnapshot.get("categoriaNome").toString()));
                            }
                        }
                    }
                });
    }
    // para fazer lista falsa, usamos o parâmetro recyclerview e position
    public static void carregarFragmentoDado(final RecyclerView principalPaginaRecyclerView, final Context context, final int index, String categoriaNome) {

        firebaseFirestore.collection("CATEGORIAS")
                .document(categoriaNome.toUpperCase())
                .collection("PRINCIPAIS_OFERTAS").orderBy("index").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot documentSnapshot : task.getResult()) {
                                long tipo = (long) documentSnapshot.get("exibir_tipo");
                                if (tipo == 0) {
                                    // para banner
                                    List<SliderModelo> sliderModeloLista = new ArrayList<>();
                                    long sem_banner = (long) documentSnapshot.get("sem_banner");
                                    for(int x = 1; x <= sem_banner; x++) {
                                        sliderModeloLista.add(new SliderModelo(documentSnapshot.get("banner_" + x).toString(), "#FFA751"));
                                    }
                                    listas.get(index).add(new PrincipalPaginaModelo(0, sliderModeloLista));

                                } else if (tipo == 1) {
                                    // para visualização horizontal do produto
                                    List<ListaComprasModelo> exibirTodosProdutosLista = new ArrayList<>();
                                    List<HorizontalProdutoScrollModelo> horizontalProdutoScrollModeloLista = new ArrayList<>();

                                    long sem_produto = (long) documentSnapshot.get("sem_produtos");

                                    for (int x = 1; x <= sem_produto; x++) {
                                        horizontalProdutoScrollModeloLista.add(new HorizontalProdutoScrollModelo(documentSnapshot.get("produto_ID_" + x).toString(),
                                                documentSnapshot.get("produto_imagem_" + x).toString(), documentSnapshot.get("produto_titulo_" + x).toString(),
                                                documentSnapshot.get("produto_subtitulo_" + x).toString(), documentSnapshot.get("produto_preco_" + x).toString()));

                                        exibirTodosProdutosLista.add(new ListaComprasModelo(documentSnapshot.get("produto_ID_" + x).toString(), documentSnapshot.get("produto_imagem_" + x).toString(),
                                                documentSnapshot.get("produto_cheio_titulo_" + x).toString(),
                                                (long) documentSnapshot.get("cupom_gratis_" + x),
                                                documentSnapshot.get("classificacao_media_" + x).toString(),
                                                (long) documentSnapshot.get("total_avaliacoes_" + x),
                                                documentSnapshot.get("produto_preco_" + x).toString(),
                                                documentSnapshot.get("reduzido_preco_" + x).toString(),
                                                (boolean) documentSnapshot.get("COD_" + x), (boolean) documentSnapshot.get("em_estoque_" + x)));
                                    }
                                    listas.get(index).add(new PrincipalPaginaModelo(1, documentSnapshot.get("layout_titulo").toString(), documentSnapshot.get("layout_background").toString(), horizontalProdutoScrollModeloLista, exibirTodosProdutosLista));
                                }
                            }
                        }
                    }
                });
    }
}
