// package com.example.crud.controller;

// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.extension.ExtendWith;
// import org.mockito.Mockito;
// import org.mockito.invocation.InvocationOnMock;
// import org.mockito.stubbing.Answer;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
// import org.springframework.boot.test.mock.mockito.MockBean;
// import org.springframework.test.context.junit.jupiter.SpringExtension;
// import org.springframework.test.web.servlet.MockMvc;

// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
// import static org.hamcrest.Matchers.is;
// import static org.mockito.BDDMockito.given;

// import java.util.Optional;

// import com.example.crud.model.Produto;
// import com.example.crud.repository.ProdutoRepository;

// @ExtendWith(SpringExtension.class)
// @WebMvcTest(ProdutoController.class)
// public class ProdutoControllerTest {

//   @Autowired
//   private MockMvc mockMvc;

//   @MockBean
//   private ProdutoRepository produtoRepository;

//   @Test
//   public void testGetProdutos() throws Exception {
//     mockMvc.perform(get("/produtos")).andExpect(status().isOk());
//   }

//   @Test
//   public void testGetProdutosById() throws Exception {
//     Produto produto = new Produto();
//     produto.setNome("Notebook");
//     produto.setPreco(2000.0);

//     given(produtoRepository.findById(Mockito.anyLong())).willReturn(Optional.of(produto));

//     mockMvc.perform(get("/produtos/{id}", 1)).andExpect(jsonPath("$.nome", is(produto.getNome())));
//   }

//   @Test
//   public void testGetProdutosByIdNotFound() throws Exception {
//     given(produtoRepository.findById(Mockito.anyLong())).willReturn(Optional.empty());

//     mockMvc.perform(get("/produtos/{id}", 1)).andExpect(status().isNotFound());
//   }

//   @Test
//   public void testPutProduto() throws Exception {
//     Produto produto = new Produto();
//     produto.setNome("Notebook");
//     produto.setPreco(2000.0);

//     given(produtoRepository.findById(Mockito.anyLong())).willReturn(Optional.of(produto));

//     given(produtoRepository.save(Mockito.any(Produto.class))).willAnswer(new Answer<Produto>() {
//       @Override
//       public Produto answer(InvocationOnMock invocation) throws Throwable {
//         return (Produto) invocation.getArgument(0);
//       }
//     });

//     mockMvc.perform(put("/produtos/{id}", 1)
//         .contentType("application/json")
//         .content("{\"nome\": \"PlayStation 5\", \"preco\": 5000.0}"))
//         .andExpect(status().isOk())
//         .andExpect(jsonPath("$.nome", is("PlayStation 5")))
//         .andExpect(jsonPath("$.preco", is(5000.0)));
//   }

//   @Test
//   public void testPutProdutoComUmArgumento() throws Exception {
//     Produto produto = new Produto();
//     produto.setNome("Notebook");
//     produto.setPreco(2000.0);

//     given(produtoRepository.findById(Mockito.anyLong())).willReturn(Optional.of(produto));

//     given(produtoRepository.save(Mockito.any(Produto.class))).willAnswer(new Answer<Produto>() {
//       @Override
//       public Produto answer(InvocationOnMock invocation) throws Throwable {
//         return (Produto) invocation.getArgument(0);
//       }
//     });

//     mockMvc.perform(put("/produtos/{id}", 1)
//         .contentType("application/json")
//         .content("{\"nome\": \"PlayStation 5\"}"))
//         .andExpect(status().isOk())
//         .andExpect(jsonPath("$.nome", is("PlayStation 5")))
//         .andExpect(jsonPath("$.preco", is(produto.getPreco())));
//   }
// }
