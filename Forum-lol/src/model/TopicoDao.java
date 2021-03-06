package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.ConnectionFactory;

public class TopicoDao {
	private Connection connection;

	public TopicoDao() throws SQLException {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void adiciona(Topico topico) {
		try {
			String sql = "insert into topico (titulo,criadorDoTopico,categoriaDoTopico,conteudo) values (?,?,?,?)";
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, topico.getTitulo());
			stmt.setInt(2, topico.getUsuario().getId());
			stmt.setInt(3, topico.getCategoria().getId());
			stmt.setString(4, topico.getConteudo());

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);

		}
	}

	public List<Topico> listar() {

		try {
			List<Topico> listaTopico = new ArrayList<Topico>();

			String sql = "SELECT * FROM topico";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				Topico topico = new Topico();

				topico.setId(rs.getInt("id"));
				topico.setTitulo(rs.getString("titulo"));
				topico.setDataCriacaoDoTopico(rs.getDate("dataCriacaoDoTopico"));
				topico.setVisualizacoes(rs.getInt("visualizacoes"));
				topico.setConteudo(rs.getString("conteudo"));

				UsuarioDao dao = new UsuarioDao();
				Usuario usuario = dao.buscarPorId(rs.getInt("criadorDoTopico"));
				topico.setUsuario(usuario);

				CategoriaDao dao2 = new CategoriaDao();
				Categoria categoria = dao2.buscarPorId(rs.getInt("categoriaDoTopico"));
				topico.setCategoria(categoria);

				listaTopico.add(topico);
			}

			rs.close();
			stmt.close();
			connection.close();

			return listaTopico;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Topico buscarPorId(int id) {
		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM topico WHERE id = ?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			Topico topico = null;

			if (rs.next()) {
				topico = new Topico();

				topico.setId(rs.getInt("id"));
				topico.setTitulo(rs.getString("titulo"));
				topico.setDataCriacaoDoTopico(rs.getDate("dataCriacaoDoTopico"));
				topico.setVisualizacoes(rs.getInt("visualizacoes"));
				topico.setConteudo(rs.getString("conteudo"));

				UsuarioDao dao = new UsuarioDao();
				Usuario usuario = dao.buscarPorId(rs.getInt("criadorDoTopico"));
				topico.setUsuario(usuario);

				CategoriaDao dao2 = new CategoriaDao();
				Categoria categoria = dao2.buscarPorId(rs.getInt("categoriaDoTopico"));
				topico.setCategoria(categoria);
			}

			rs.close();
			stmt.close();
			connection.close();

			return topico;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void alterar(Topico topico) {

		try {
			String sql = "UPDATE topico SET titulo = ?, criadorDoTopico = ?, categoriaDoTopico = ?, conteudo = ? WHERE id = ?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, topico.getTitulo());
			stmt.setInt(2, topico.getUsuario().getId());
			stmt.setInt(3, topico.getCategoria().getId());
			stmt.setString(4, topico.getConteudo());
			stmt.setInt(5, topico.getId());

			stmt.execute();
			connection.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public void remover(Topico topico) {


		try {
			String sql = "DELETE FROM topico WHERE id = ?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, topico.getId());
			stmt.execute();
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	
	}
}
